package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*                                          Single Table Intheritance
 *
 *  Her objenin ortak olarak kullandığı bir tablo var, tüm veriler oraya yazılıyor.
 *
 *  Single table inheritance'da User üzerinden query yapılabiliyor,
 * User üzerinden yapılan queryler diğer inheritance tiplerine kıyasla daha hızlı
 * Çünkü sadece 1 tablodan arama yaıyor.
 *
 *  Ortak fieldlar not null olamaz
 *
 *  Define edilmemiş bir veri discriminator column'a girerse
 * "Other" sınıfı yazılıp, discriminator value'su "not null" atanır,
 *  Böylece getAll() diğer tüm verileri getirir
 *
 */

/*                                          Mapped Super Class
 *
 *  Genel olarak OOP yapısına benzemekte. Üst sınıf Abstract olup @Entity anotasyonu yazılmaz.
 *  Her objenin kendine ait ve üst sınıftan gelen alanları barındıran tablosu var.
 *
 *  Attribute Override yapılabiliyor,
 *  örn: Kişi(katılımTarihi) sınıfından türeyen doktorun(girişTarihi) ve hastanın(randevuTarihi)
 *  farklı fieldlar adı altında aynı veriye sahip olabilmesi. Bu durumda;
 *
 *  Kişi'de:
 *  @Temporal(TemporalType.DATE)
 *  private Date entryDate;
 *
 *  Doktor'da:
 *  @AttribudeOverride(name = "entry_date", column = @Column(name = "joining_date")
 *
 *  Hasta'da:
 *  @AttribudeOverride(name = "entry_date", column = @Column(name = "visit_date")
 *
 *  Dezavantajları:
 *  - Polymorhpic Query yapılamamakta
 *  - Eğer yapı Üst->Orta->Alt sınıf şeklindeyse sorgu yapabilmek için çok yönlü bağlantı kurulmalı,
 *  böyle yapılar için diğer inheritance türlerine bakılmalı.
 *
 *
 */

/*                                          Table Per Class
 *
 *  Her objenin kendine ait tablosu var, alt sınıf tabloları üst sınıfın alanlarına da sahip.
 *
 *  Dezavantajlarından biri üst sınıfı arayan bir Query yapıldığında hibernate çok komplike bir sorgu yazmakta.
 *  Her tablo için ayrı sorgu yazılıp UNION ALL ile sorgular birleştiriliyor.
 *  Tekli yani alt sınıfı içeren sorgu yapıldığında, miras yokmuş gibi tek tablo sorgusu yapılmakta.
 *  Bu komplekslikten dolayı sadece gerekli durumlarda kullanılmalı.
 *
 *  Örnek kullanım tipi: Bir üretici hem araba hem de motorsiklet üretmekte.
 *
 *  Motorcycle extends Vehicle
 *  Car extends Vehicle
 *
 *  Üretici birden çok araç üretebilmekte (@OneToMany)
 *
 *  Manufacturer
 *  @OneToMany
 *  @JoinColumn(name = "manufacturer_id")
 *  Set<Vehicle> vehicles;
 *
 *  private int manufacturer_id; -> Eğer bu alan yazılmazsa, post metodunda manufacturer_id verildiğine
 *  veritabanında null değerli bir manufacturer_id oluşmakta
 *
 *  Vehicle
 *  @JsonIgnore
 *  @ManyToOne
 *  @JoinColumn(name = "manufacturer_id", insertable = false, updateable = false)
 *  Yukarıdaki ifadenin sebebi her araç üretilirken tek bir üretici tarafından üretilir ve bu üretici değiştirilemez.
 *  Araçtaki şase numarası gibi...
 *  private Manufacturer manufacturer;
 *
 *  Bu stratejide ekleme metodu single table inheritance ile benzerlik göstermekte.
 *  manufacturer_id girilmesi ZORUNLU.
 *
 */

/*                                          Joined Table
 *
 *  Table Per Class stratejisi ile benzerlik göstermekte fakat üst sınıfın da tablosu var.
 *  Her tabloda id var
 *  Genel olarak karmaşık bir yapıya sahip
 *  Query yapmak genel olarak düşük performans ile gerçekleşmekte,
 *  Üst sınıfı ararken her alt sınıfı bağlayıp aradığından dolayı performans düşüklüğü olmakta
 *  Tablolar birbirlerine One To Many ve Many To One ile bağlanıyor
 *  Kullanım örneklerine bakmak gerekli.
 *
 * */


/*                       Tüm inheritance tiplerinde primary key sadece üst sınıfta oluyor (@Id)                       */

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @JsonIgnore
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    // TODO istenmeyen bir field'ın GET'te görünmesini engellemenin bir yolunu bul
    @Transient
    private String passwordRepeat;

    @Column(name = "created_date")
    @JsonIgnore
    private String create_date;

}
