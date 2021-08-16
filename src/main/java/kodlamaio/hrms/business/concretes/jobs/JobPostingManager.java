package kodlamaio.hrms.business.concretes.jobs;

import kodlamaio.hrms.business.abstracts.jobs.JobPostingService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.dataAccess.abstracts.users.EmployerDao;
import kodlamaio.hrms.entities.concretes.jobs.JobPosting;
import kodlamaio.hrms.entities.concretes.dtos.JobPostingDto;
import kodlamaio.hrms.entities.concretes.dtos.JobPostingWithEmployerAndJobPositionDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobPostingManager implements JobPostingService {

    private final JobPostingDao jobPostingDao;

    private final EmployerDao employerDao;
    private final CityDao cityDao;
    private final JobPositionDao jobPositionDao;

    public JobPostingManager(JobPostingDao jobPostingDao, EmployerDao employerDao, CityDao cityDao, JobPositionDao jobPositionDao) {
        this.jobPostingDao = jobPostingDao;
        this.employerDao = employerDao;
        this.cityDao = cityDao;
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public Result addJobPosting(JobPostingDto dto){

        JobPosting jobPosting = new JobPosting();

        if(!employerDao.existsById(dto.getEmployerID())) return new ErrorResult("İş veren bulunamadı");
        else jobPosting.setEmployer(employerDao.getById(dto.getEmployerID()));

        if(!cityDao.existsById(dto.getCityId())) return new ErrorResult("Şehir bulunamadı");
        else jobPosting.setCity(cityDao.getById(dto.getCityId()));

        if(!jobPositionDao.existsById(dto.getJobPositionId())) return new ErrorResult("İş pozisyonu bulunamadı");
        else jobPosting.setJobPosition(jobPositionDao.getById(dto.getJobPositionId()));

        jobPosting.setJobDescription(dto.getJobDescription());
        jobPosting.setSalaryMin(dto.getSalaryMin());
        jobPosting.setSalaryMax(dto.getSalaryMax());
        jobPosting.setSalary(dto.getSalary());
        jobPosting.setOpenPositions(dto.getOpenPositions());
        jobPosting.setReleaseDate(dto.getReleaseDate());
        jobPosting.setApplicationDeadline(dto.getApplicationDeadline());

        jobPostingDao.save(jobPosting);
        return new SuccessResult(jobPosting.getJobDescription() + " eklendi");
    }

    @Override
    public Result deactivatePosting(int jobPostingId) {
        if(jobPostingDao.existsById(jobPostingId)){
            JobPosting posting = jobPostingDao.getById(jobPostingId);
            posting.setActive(false);
            jobPostingDao.saveAndFlush(posting);
            return new SuccessResult("İlan deaktive edildi");
        }else{
            return new ErrorResult("İlan bulunamadi");
        }
    }

    @Override
    public DataResult<List<JobPostingWithEmployerAndJobPositionDto>> getAllActive() {
        return new DataResult<>(jobPostingListingDtoList(jobPostingDao.getAllByIsActiveIsTrue()), true,"Veri getirildi");
    }

    @Override
    public DataResult<List<JobPostingWithEmployerAndJobPositionDto>> getAllByDeadline() {
        return new DataResult<>(jobPostingListingDtoList(jobPostingDao.getAllByIsActiveIsTrueOrderByApplicationDeadline()), true,"Veri getirildi");
    }

    @Override
    public DataResult<List<JobPostingWithEmployerAndJobPositionDto>> getAllByEmployer(int employerId) {
        return new DataResult<>(jobPostingListingDtoList(jobPostingDao.getAllByEmployer_Id(employerId)), true,"Veri getirildi");
    }

    @Override
    public DataResult<List<JobPostingWithEmployerAndJobPositionDto>> getAllCustom() {
        return new SuccessDataResult<>(jobPostingDao.getAllByActiveStatus(true)); //ileriye dönük
    }

    @Override
    public DataResult<List<JobPostingWithEmployerAndJobPositionDto>> getAllByCompanyName(String companyName, boolean isActive) {
        return new SuccessDataResult<>(jobPostingDao.getAllByCompanyName(companyName, isActive), "Veri getirildi");
    }

    private List<JobPostingWithEmployerAndJobPositionDto> jobPostingListingDtoList(List<JobPosting> jobPostingList){
        List<JobPostingWithEmployerAndJobPositionDto> jobPostingWithEmployerAndJobPositionDtos = new ArrayList<>();
        JobPostingWithEmployerAndJobPositionDto dto;

        for (JobPosting posting : jobPostingList) {
            dto = new JobPostingWithEmployerAndJobPositionDto();
            dto.setId(posting.getId());
            dto.setCompanyName(posting.getEmployer().getCompanyName());
            dto.setJobTitle(posting.getJobPosition().getTitle());
            dto.setOpenPositions(posting.getOpenPositions());
            dto.setPublishDate(posting.getReleaseDate());
            dto.setAplicationDeadlineDate(posting.getApplicationDeadline());
            jobPostingWithEmployerAndJobPositionDtos.add(dto);
        }
        return jobPostingWithEmployerAndJobPositionDtos;
    }

}
