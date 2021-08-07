package kodlamaio.hrms.entities.concretes.users;

import kodlamaio.hrms.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity

public class Employer extends User {

    @Column(name = "web_adress")
    private String webAdress;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "is_activated_by_staff")
    private boolean isActivatedByStaff;

}
