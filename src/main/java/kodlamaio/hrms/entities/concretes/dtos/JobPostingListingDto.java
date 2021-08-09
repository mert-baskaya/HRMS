package kodlamaio.hrms.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class JobPostingListingDto {

    private int id;
    private String companyName;
    private String jobTitle;
    private int openPositions;
    private Date publishDate;
    private Date aplicationDeadlineDate;

}
