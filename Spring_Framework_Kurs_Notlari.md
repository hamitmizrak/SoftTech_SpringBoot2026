# Spring Framework’e Giriş – Detaylı Kurs Notları

Bu dosya, PowerPoint içindeki konuşmacı notlarının düz metin karşılığıdır. Kurs anlatırken slaytlar kısa tutuldu; detaylar burada genişletildi.

## Resmi Kaynaklar

- Spring Framework Reference: https://docs.spring.io/spring-framework/reference/
- Spring Boot Reference: https://docs.spring.io/spring-boot/reference/
- Spring AI Reference: https://docs.spring.io/spring-ai/reference/

## Genel Amaç

Spring Framework öğrenmek; yalnızca annotation kullanmayı değil, IoC container, dependency injection, bean yaşam döngüsü, transaction, web request akışı, data access, security, testing, production deployment ve AI entegrasyonunu runtime davranışıyla anlamaktır.

## Ön Bilgi: Spring Framework nedir?

Spring Framework kurumsal Java uygulamalarında nesne yönetimi, bağımlılık yönetimi, transaction, web, veri erişimi, AOP ve test altyapısını modüler biçimde sağlayan temel framework’tür. Spring Boot bu temel üzerinde hızlı başlangıç ve otomatik yapılandırma sağlar. DI genel prensip, CDI Jakarta standardı, Spring IoC ise Spring’in kendi container modelidir. XML ise özellikle legacy Spring projelerinde konfigürasyon okuma açısından önemlidir.


# Temel Kavramlar

IoC, DI, Bean ve konfigürasyon zihniyetini kurmak.

## 1. Spring Ekosistemi ve Spring Framework Mimarisi

Spring; Core Container, AOP, Data Access, Web, Test ve entegrasyon modüllerinden oluşan kurumsal Java çatısıdır.
Amaç; nesne oluşturma, bağımlılık yönetimi, transaction, web ve güvenlik gibi tekrar eden işleri standartlaştırmaktır.
Mimariyi öğrenmek, Spring Boot kullansanız bile alttaki kararları doğru vermenizi sağlar.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: IoC, DI, Bean ve konfigürasyon zihniyetini kurmak. Spring Ekosistemi ve Spring Framework Mimarisi bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 2. Spring Framework vs Spring Boot

Framework temel altyapıdır; Boot bu altyapıyı hızlı başlatan, otomatik yapılandıran üretkenlik katmanıdır.
Spring Boot, starter dependency ve auto configuration ile boilerplate azaltır.
Framework bilinmeden Boot hataları “sihir” gibi görünür; Framework bilen geliştirici nedeni teşhis eder.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: IoC, DI, Bean ve konfigürasyon zihniyetini kurmak. Spring Framework vs Spring Boot bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 3. IoC – Inversion of Control

Nesnenin yaşamını ve bağımlılıklarını uygulama kodu değil container yönetir.
new ile sıkı bağımlılık kurmak yerine nesneler container’dan alınır.
IoC; test edilebilirlik, gevşek bağlılık ve merkezi konfigürasyon sağlar.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: IoC, DI, Bean ve konfigürasyon zihniyetini kurmak. IoC – Inversion of Control bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 4. DI – Dependency Injection

Bir sınıfın ihtiyaç duyduğu nesneler dışarıdan verilir.
Constructor, setter veya field üzerinden uygulanabilir; kurumsal kodda constructor injection tercih edilir.
DI ile sınıf kendi bağımlılığını üretmez, sadece iş kuralına odaklanır.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: IoC, DI, Bean ve konfigürasyon zihniyetini kurmak. DI – Dependency Injection bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 5. IoC Container

Spring container bean tanımlarını okur, nesneleri üretir, bağlar, başlatır ve kapatır.
ApplicationContext modern ve zengin container arayüzüdür.
Container; scope, lifecycle callback, event, environment ve resource erişimini yönetir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: IoC, DI, Bean ve konfigürasyon zihniyetini kurmak. IoC Container bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 6. Bean Kavramı

Bean, Spring container tarafından yönetilen nesnedir.
Bir sınıfın bean olması için component scan veya explicit @Bean tanımı gerekir.
Bean adı, tipi, scope’u ve lifecycle davranışı container tarafından takip edilir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: IoC, DI, Bean ve konfigürasyon zihniyetini kurmak. Bean Kavramı bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 7. ApplicationContext ve BeanFactory

BeanFactory temel IoC sözleşmesidir; ApplicationContext bunun üzerine event, i18n, resource ve AOP kabiliyetleri ekler.
Modern Spring uygulamalarında neredeyse daima ApplicationContext kullanılır.
BeanFactory daha düşük seviye ve lazy odaklıdır; ApplicationContext kurumsal uygulama context’idir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: IoC, DI, Bean ve konfigürasyon zihniyetini kurmak. ApplicationContext ve BeanFactory bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 8. Bean Lifecycle

Tanım okuma, instance oluşturma, dependency injection, aware callback, post processor, init, kullanım ve destroy aşamalarından oluşur.
Lifecycle bilmek; bağlantı açma-kapatma, resource temizleme ve proxy davranışını anlamak için kritiktir.
@PostConstruct ve @PreDestroy sık kullanılan lifecycle callback örnekleridir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: IoC, DI, Bean ve konfigürasyon zihniyetini kurmak. Bean Lifecycle bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 9. Bean Scope

Scope, bean instance sayısını ve yaşam süresini belirler.
singleton varsayılandır; prototype her istek için yeni nesne üretir.
web ortamında request, session, application gibi scope’lar vardır.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: IoC, DI, Bean ve konfigürasyon zihniyetini kurmak. Bean Scope bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 10. Component Scanning

Spring belirlenen package ağacını tarar ve stereotype annotation taşıyan sınıfları bean yapar.
Ana uygulama sınıfının package konumu tarama alanını belirler.
Yanlış package yerleşimi bean bulunamadı hatalarının yaygın nedenidir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: IoC, DI, Bean ve konfigürasyon zihniyetini kurmak. Component Scanning bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 11. Stereotype Annotations

@Component genel bean; @Service iş katmanı; @Repository veri erişimi; @Controller web katmanı niyetini gösterir.
Teknik olarak çoğu component scan ile bean üretir; semantik fark mimari okunabilirlik sağlar.
@Repository exception translation gibi ek davranışlar da sağlayabilir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: IoC, DI, Bean ve konfigürasyon zihniyetini kurmak. Stereotype Annotations bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 12. @Component

Genel amaçlı Spring bean annotation’ıdır.
Belirli katman anlamı yoksa yardımcı servis, converter, utility adapter gibi yapılarda kullanılır.
Aşırı kullanılırsa mimari niyet kaybolur; uygun stereotype seçimi önemlidir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: IoC, DI, Bean ve konfigürasyon zihniyetini kurmak. @Component bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 13. @Service

Business logic katmanı için kullanılır.
Controller’dan gelen isteği iş kuralına çevirir, transaction sınırlarını taşıyabilir.
Repository doğrudan controller’a bağlanmamalı; service katmanı arada olmalıdır.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: IoC, DI, Bean ve konfigürasyon zihniyetini kurmak. @Service bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 14. @Repository

Veri erişim katmanını temsil eder.
DAO/repository sınıflarında kullanılır ve persistence exception translation desteği verir.
SQL/JPA/NoSQL detaylarını service katmanından izole eder.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: IoC, DI, Bean ve konfigürasyon zihniyetini kurmak. @Repository bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 15. @Controller

Spring MVC’de web controller sınıfıdır.
View döndüren klasik MVC uygulamalarında kullanılır.
REST için çoğunlukla @RestController daha doğrudur.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: IoC, DI, Bean ve konfigürasyon zihniyetini kurmak. @Controller bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 16. Dependency Injection Yöntemleri

Constructor, setter ve field injection Spring’in bağımlılık verme yollarıdır.
Constructor injection zorunlu bağımlılıkları açıkça gösterir ve test kolaylığı sağlar.
Setter opsiyonel bağımlılıklar için, field injection ise eğitim dışında genellikle kaçınılması gereken pratik olarak görülür.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: IoC, DI, Bean ve konfigürasyon zihniyetini kurmak. Dependency Injection Yöntemleri bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 17. Constructor Injection

Bağımlılıklar constructor parametresiyle verilir.
final field kullanımına izin verdiği için immutable ve test edilebilir sınıflar üretir.
Döngüsel bağımlılıkları erken ortaya çıkarır.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: IoC, DI, Bean ve konfigürasyon zihniyetini kurmak. Constructor Injection bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 18. Setter Injection

Bağımlılık setter metodu üzerinden atanır.
Opsiyonel veya sonradan değişebilir bağımlılıklar için uygundur.
Zorunlu bağımlılıkta nesne eksik state ile oluşabileceği için dikkat ister.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: IoC, DI, Bean ve konfigürasyon zihniyetini kurmak. Setter Injection bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 19. Field Injection

Bağımlılık doğrudan field üzerine enjekte edilir.
Kod kısa görünür ama test, immutability ve açık bağımlılık açısından zayıftır.
Üretim kodunda çoğunlukla constructor injection tercih edilmelidir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: IoC, DI, Bean ve konfigürasyon zihniyetini kurmak. Field Injection bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 20. @Autowired

Spring’in otomatik bağımlılık çözme annotation’ıdır.
Tip bazlı arama yapar; birden fazla aday varsa @Qualifier veya @Primary gerekir.
Tek constructor varsa modern Spring’de @Autowired yazılmadan da injection yapılabilir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: IoC, DI, Bean ve konfigürasyon zihniyetini kurmak. @Autowired bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 21. @Qualifier

Aynı tipten birden fazla bean olduğunda hangi bean’in enjekte edileceğini belirtir.
Özellikle interface’in birden çok implementasyonu olduğunda kullanılır.
Bean adlarını string ile bağladığı için refactor sırasında dikkat ister.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: IoC, DI, Bean ve konfigürasyon zihniyetini kurmak. @Qualifier bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 22. @Primary

Birden fazla aday olduğunda varsayılan bean’i belirler.
@Qualifier yoksa primary bean seçilir.
Genel varsayılan için iyidir; özel seçim gereken yerde @Qualifier daha net olur.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: IoC, DI, Bean ve konfigürasyon zihniyetini kurmak. @Primary bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 23. Java-Based Configuration

XML yerine Java sınıflarıyla bean ve ayar tanımlama yaklaşımıdır.
Tip güvenliği, refactor kolaylığı ve IDE desteği sağlar.
Modern Spring ve Boot projelerinde ana konfigürasyon tarzıdır.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: IoC, DI, Bean ve konfigürasyon zihniyetini kurmak. Java-Based Configuration bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 24. @Configuration

Bean tanımları içeren konfigürasyon sınıfını belirtir.
İçindeki @Bean metotları container tarafından yönetilir.
Proxy davranışı sayesinde aynı @Bean metodu çağrılsa bile singleton sözleşmesi korunur.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: IoC, DI, Bean ve konfigürasyon zihniyetini kurmak. @Configuration bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 25. @Bean

Bir nesneyi manuel olarak Spring bean yapmak için kullanılır.
Üçüncü parti sınıflar veya özel factory mantığı için idealdir.
Metot adı varsayılan bean adı olur; name attribute ile özelleştirilebilir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: IoC, DI, Bean ve konfigürasyon zihniyetini kurmak. @Bean bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 26. XML-Based Configuration

Bean tanımlarının XML dosyasında yapıldığı eski ama halen anlaşılması değerli konfigürasyon biçimidir.
XML; tag tabanlı, hiyerarşik veri ve yapılandırma formatıdır.
Legacy projelerde, entegrasyon sistemlerinde ve bazı kurumsal yapılarda karşınıza çıkabilir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: IoC, DI, Bean ve konfigürasyon zihniyetini kurmak. XML-Based Configuration bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 27. Properties ve Environment Yönetimi

Ayarları koddan ayırıp properties/yaml/env değişkenleriyle yönetmektir.
DB URL, port, token, profil ve feature flag gibi değerler environment üzerinden okunur.
12-factor prensibine uygun production deployment için zorunludur.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: IoC, DI, Bean ve konfigürasyon zihniyetini kurmak. Properties ve Environment Yönetimi bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 28. @Value

Properties veya SpEL ifadelerini field/constructor parametresine bağlar.
Basit tekil değerler için uygundur.
Çok sayıda ayar için @ConfigurationProperties daha düzenli tercih edilir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: IoC, DI, Bean ve konfigürasyon zihniyetini kurmak. @Value bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 29. Spring Profiles – @Profile

Farklı ortamlar için farklı bean veya konfigürasyon seçmeyi sağlar.
dev, test, prod gibi ortam ayrımı yapılır.
Yanlış profil production’da kritik bağlantı veya güvenlik hatalarına yol açabilir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: IoC, DI, Bean ve konfigürasyon zihniyetini kurmak. Spring Profiles – @Profile bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 30. Spring Expression Language – SpEL

Runtime expression değerlendirme dilidir.
Bean property, method call, collection, condition ve security ifadelerinde kullanılabilir.
Güçlüdür ancak karmaşık iş kurallarını annotation içine gömmek okunabilirliği azaltır.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: IoC, DI, Bean ve konfigürasyon zihniyetini kurmak. Spring Expression Language – SpEL bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.


# AOP, Event, Transaction ve Data

Kurumsal uygulamanın veri, transaction ve kesitsel davranış temelini oturtmak.

## 31. Spring AOP – Aspect Oriented Programming

Logging, transaction, security gibi kesitsel konuları iş kodundan ayırır.
Proxy tabanlı yaklaşım ile metot çağrılarına ek davranış eklenir.
AOP, core business logic’in sade kalmasını sağlar.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Kurumsal uygulamanın veri, transaction ve kesitsel davranış temelini oturtmak. Spring AOP – Aspect Oriented Programming bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 32. Aspect, Advice, Pointcut ve Join Point

Aspect kesitsel modüldür; advice çalışacak ek davranıştır; pointcut nerede çalışacağını seçer; join point yakalanan noktadır.
Spring AOP çoğunlukla method execution join point kullanır.
Yanlış pointcut beklenmeyen metotlarda performans ve davranış sorunları doğurabilir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Kurumsal uygulamanın veri, transaction ve kesitsel davranış temelini oturtmak. Aspect, Advice, Pointcut ve Join Point bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 33. @Aspect

Bir sınıfı AOP aspect olarak işaretler.
@Before, @After, @Around gibi advice metotları içerir.
@Around en güçlü ama en riskli advice türüdür; proceed çağrısı unutulmamalıdır.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Kurumsal uygulamanın veri, transaction ve kesitsel davranış temelini oturtmak. @Aspect bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 34. Spring Events

Publisher-listener modeliyle gevşek bağlı olay iletişimi sağlar.
ApplicationEventPublisher ile event yayınlanır, @EventListener ile dinlenir.
Email gönderme, audit, bildirim gibi yan etkiler için kullanışlıdır.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Kurumsal uygulamanın veri, transaction ve kesitsel davranış temelini oturtmak. Spring Events bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 35. Transaction Management

Birden çok DB işleminin atomik bütün olarak yönetilmesidir.
Commit başarılı sonucu, rollback hata durumunu temsil eder.
Kurumsal veri tutarlılığı için transaction sınırları doğru katmanda kurulmalıdır.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Kurumsal uygulamanın veri, transaction ve kesitsel davranış temelini oturtmak. Transaction Management bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 36. @Transactional

Metot veya sınıf üzerinde transaction davranışını tanımlar.
Runtime exception durumunda varsayılan rollback davranışı vardır.
Self-invocation, private method ve proxy sınırları sık yapılan hatalardır.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Kurumsal uygulamanın veri, transaction ve kesitsel davranış temelini oturtmak. @Transactional bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 37. Spring JDBC

JDBC kullanımını Spring altyapısıyla sadeleştirir.
Connection açma-kapama ve exception dönüşümü gibi tekrarları azaltır.
ORM istemeyen ama SQL kontrolü isteyen projeler için uygundur.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Kurumsal uygulamanın veri, transaction ve kesitsel davranış temelini oturtmak. Spring JDBC bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 38. JdbcTemplate

SQL çalıştırma, parametre bağlama ve result mapping işlemlerini kolaylaştırır.
Boilerplate JDBC kodunu ciddi azaltır.
SQL performans kontrolü gereken servislerde halen değerli bir seçenektir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Kurumsal uygulamanın veri, transaction ve kesitsel davranış temelini oturtmak. JdbcTemplate bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 39. Spring ORM

Hibernate/JPA gibi ORM araçlarını Spring transaction ve bean modeliyle entegre eder.
Session/EntityManager yönetimini kolaylaştırır.
ORM soyutlama sağlasa da N+1, lazy loading ve transaction sınırları bilinmelidir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Kurumsal uygulamanın veri, transaction ve kesitsel davranış temelini oturtmak. Spring ORM bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 40. JPA ve Hibernate Entegrasyonu

JPA standart arayüz; Hibernate en yaygın implementasyondur.
EntityManager, persistence context ve entity lifecycle ana kavramlardır.
Spring, repository ve transaction ile JPA kullanımını üretim seviyesinde kolaylaştırır.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Kurumsal uygulamanın veri, transaction ve kesitsel davranış temelini oturtmak. JPA ve Hibernate Entegrasyonu bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 41. Spring Data JPA

Repository arayüzlerinden otomatik veri erişim implementasyonu üretir.
Method name query, @Query, pagination ve specification destekler.
Hızlı CRUD sağlar ama karmaşık sorgularda SQL/JPA bilgisi hâlâ gerekir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Kurumsal uygulamanın veri, transaction ve kesitsel davranış temelini oturtmak. Spring Data JPA bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 42. Repository Mimarisi

Veri erişimini interface tabanlı soyutlar.
Service katmanı persistence detaylarını bilmeden çalışır.
Repository sadece veri erişiminden sorumlu olmalı, iş kuralı taşımamalıdır.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Kurumsal uygulamanın veri, transaction ve kesitsel davranış temelini oturtmak. Repository Mimarisi bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 43. CRUD İşlemleri

Create, Read, Update, Delete temel veri operasyonlarıdır.
REST endpoint, service transaction ve repository çağrısı zinciriyle uygulanır.
Soft delete, audit ve validation kurumsal CRUD için ek gereksinimlerdir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Kurumsal uygulamanın veri, transaction ve kesitsel davranış temelini oturtmak. CRUD İşlemleri bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 44. Entity Relationships

Entity’ler arası OneToOne, OneToMany, ManyToOne, ManyToMany ilişkilerini ifade eder.
Owning side, cascade, fetch type ve orphan removal kritik ayarlardır.
Yanlış ilişki modelleme performans ve veri bütünlüğü sorunları üretir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Kurumsal uygulamanın veri, transaction ve kesitsel davranış temelini oturtmak. Entity Relationships bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 45. Validation

Gelen veriyi iş kuralı öncesi doğrulama sürecidir.
Jakarta Bean Validation ile @NotNull, @Email, @Size gibi annotation’lar kullanılır.
DTO seviyesinde validation API sözleşmesini korur.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Kurumsal uygulamanın veri, transaction ve kesitsel davranış temelini oturtmak. Validation bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.


# Web, REST ve Hata Yönetimi

MVC, DispatcherServlet, REST, filter/interceptor ve exception akışını anlamak.

## 46. Spring MVC

Servlet tabanlı web framework’tür.
Controller, model, view veya REST response akışını yönetir.
DispatcherServlet merkezli request handling modeli üzerine kuruludur.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: MVC, DispatcherServlet, REST, filter/interceptor ve exception akışını anlamak. Spring MVC bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 47. MVC Mimarisi

Model veriyi, View sunumu, Controller istek akışını temsil eder.
Sorumluluk ayrımı sayesinde frontend/backend veya server-side view yapıları düzenlenir.
REST projelerinde View yerini JSON response alır.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: MVC, DispatcherServlet, REST, filter/interceptor ve exception akışını anlamak. MVC Mimarisi bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 48. DispatcherServlet

Spring MVC’nin front controller bileşenidir.
Tüm requestleri karşılar, handler mapping, adapter, binding ve view/response sürecini yönetir.
MVC akışını anlamanın en merkezi kavramıdır.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: MVC, DispatcherServlet, REST, filter/interceptor ve exception akışını anlamak. DispatcherServlet bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 49. Controller Yapısı

HTTP isteğini alır, input doğrular, service çağırır ve response döner.
Controller’da iş kuralı değil orkestrasyon bulunmalıdır.
İnce controller, test edilebilir ve sürdürülebilir mimari sağlar.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: MVC, DispatcherServlet, REST, filter/interceptor ve exception akışını anlamak. Controller Yapısı bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 50. Request Mapping

URL, HTTP method, consumes/produces gibi kriterlere göre handler eşler.
@GetMapping, @PostMapping gibi kısayollar okunabilirlik sağlar.
Endpoint tasarımında isimlendirme ve HTTP semantiği önemlidir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: MVC, DispatcherServlet, REST, filter/interceptor ve exception akışını anlamak. Request Mapping bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 51. Request Parameter / Path Variable

RequestParam query string değerlerini, PathVariable URL path içindeki değerleri alır.
Filtreleme/sıralama için query param; kaynak kimliği için path variable kullanılır.
Doğru ayrım REST tasarımını okunabilir kılar.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: MVC, DispatcherServlet, REST, filter/interceptor ve exception akışını anlamak. Request Parameter / Path Variable bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 52. Form ve Model Yönetimi

Server-side MVC’de form verisi binding, validation ve model ile view’a taşınır.
ModelAttribute form nesnesini bağlar.
Hata mesajları ve validation sonuçları kullanıcı deneyimi için önemlidir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: MVC, DispatcherServlet, REST, filter/interceptor ve exception akışını anlamak. Form ve Model Yönetimi bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 53. REST API Geliştirme

Kaynak odaklı, HTTP tabanlı API geliştirme yaklaşımıdır.
JSON, status code, idempotency ve endpoint standardı temel konulardır.
REST API dış sistemler, frontend ve mobil istemciler için sözleşme üretir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: MVC, DispatcherServlet, REST, filter/interceptor ve exception akışını anlamak. REST API Geliştirme bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 54. @RestController

@Controller + @ResponseBody birleşimidir.
Metot dönüşleri view değil doğrudan HTTP response body olur.
JSON API geliştirmede standart controller annotation’ıdır.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: MVC, DispatcherServlet, REST, filter/interceptor ve exception akışını anlamak. @RestController bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 55. @RequestBody

HTTP request body içindeki JSON/XML veriyi Java nesnesine dönüştürür.
DTO ile birlikte kullanılmalıdır.
Content-Type ve deserialization hataları sık görülür.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: MVC, DispatcherServlet, REST, filter/interceptor ve exception akışını anlamak. @RequestBody bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 56. ResponseEntity

Body, status code ve header değerlerini birlikte kontrol etmeyi sağlar.
201 Created, 204 No Content, 400 Bad Request gibi yanıtlar net üretilir.
API sözleşmesini profesyonel hale getirir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: MVC, DispatcherServlet, REST, filter/interceptor ve exception akışını anlamak. ResponseEntity bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 57. Exception Handling

Hataların kontrollü yakalanıp anlamlı response’a çevrilmesidir.
Stack trace kullanıcıya gösterilmez; standart hata modeli döndürülür.
Tekrarlı try-catch yerine merkezi hata yönetimi tercih edilir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: MVC, DispatcherServlet, REST, filter/interceptor ve exception akışını anlamak. Exception Handling bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 58. @ControllerAdvice

Controller’lar için merkezi exception, binding ve model advice tanımlar.
@ExceptionHandler ile global hata cevapları üretir.
REST API hata standardizasyonunun ana mekanizmasıdır.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: MVC, DispatcherServlet, REST, filter/interceptor ve exception akışını anlamak. @ControllerAdvice bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 59. Global Exception Handling

Tüm uygulama için tek tip hata yanıtı üretir.
Hata kodu, mesaj, timestamp, path ve validation detayları standardize edilir.
Frontend ve mobil ekipler için öngörülebilir API davranışı sağlar.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: MVC, DispatcherServlet, REST, filter/interceptor ve exception akışını anlamak. Global Exception Handling bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 60. Interceptor

Spring MVC seviyesinde request öncesi/sonrası davranış ekler.
HandlerInterceptor ile auth kontrolü, logging, locale gibi işler yapılabilir.
Controller seçildikten sonra devreye girdiği için Filter’dan farklıdır.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: MVC, DispatcherServlet, REST, filter/interceptor ve exception akışını anlamak. Interceptor bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 61. Filter

Servlet seviyesinde request/response zincirinde çalışır.
Security, CORS, encoding ve low-level request işleme için uygundur.
Controller mapping’den önce çalışır; kapsamı interceptor’dan daha geneldir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: MVC, DispatcherServlet, REST, filter/interceptor ve exception akışını anlamak. Filter bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.


# Security, Test ve Entegrasyon

Kimlik doğrulama, yetkilendirme, test, cache, async ve reactive seçeneklerini öğretmek.

## 62. Spring Security

Authentication, authorization, CSRF, session, filter chain gibi güvenlik bileşenlerini yönetir.
Varsayılan güvenlik sağlayarak açıkları azaltır.
Doğru yapılandırılmazsa erişim, CORS veya CSRF sorunları doğurabilir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Kimlik doğrulama, yetkilendirme, test, cache, async ve reactive seçeneklerini öğretmek. Spring Security bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 63. Authentication

Kullanıcının kim olduğunu doğrulama sürecidir.
Username/password, JWT, OAuth2 gibi yöntemler kullanılabilir.
Sonuçta SecurityContext içinde Authentication nesnesi oluşur.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Kimlik doğrulama, yetkilendirme, test, cache, async ve reactive seçeneklerini öğretmek. Authentication bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 64. Authorization

Doğrulanmış kullanıcının hangi kaynağa erişebileceğini belirler.
Role, authority, method security ve URL security ile uygulanır.
Authentication kimliktir; authorization yetkidir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Kimlik doğrulama, yetkilendirme, test, cache, async ve reactive seçeneklerini öğretmek. Authorization bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 65. Role ve Authority

Authority spesifik izin; role çoğunlukla ROLE_ prefix’li yetki grubudur.
hasRole ve hasAuthority farkı bilinmelidir.
İyi tasarımda role iş unvanı değil erişim politikasıdır.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Kimlik doğrulama, yetkilendirme, test, cache, async ve reactive seçeneklerini öğretmek. Role ve Authority bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 66. Password Encoding

Şifrelerin düz metin değil hashlenmiş saklanmasıdır.
BCryptPasswordEncoder yaygın tercihtir.
Encode tek yönlüdür; login sırasında ham şifre hash ile karşılaştırılır.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Kimlik doğrulama, yetkilendirme, test, cache, async ve reactive seçeneklerini öğretmek. Password Encoding bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 67. Session-Based Authentication

Login sonrası server tarafında session tutulur.
Klasik web uygulamalarında pratik ve güvenlidir.
Yatay ölçeklemede sticky session veya merkezi session store ihtiyacı doğabilir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Kimlik doğrulama, yetkilendirme, test, cache, async ve reactive seçeneklerini öğretmek. Session-Based Authentication bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 68. JWT Authentication

Token tabanlı stateless kimlik doğrulamadır.
Access token request header ile taşınır.
Token süresi, refresh token, imza ve blacklist stratejisi dikkat ister.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Kimlik doğrulama, yetkilendirme, test, cache, async ve reactive seçeneklerini öğretmek. JWT Authentication bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 69. CORS / CSRF

CORS tarayıcı kaynak paylaşım politikasını; CSRF kullanıcı oturumunu kötüye kullanma saldırısını ilgilendirir.
REST frontend ayrı domainde ise CORS ayarı gerekir.
Session tabanlı sistemlerde CSRF koruması önemlidir; stateless JWT’de yaklaşım farklıdır.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Kimlik doğrulama, yetkilendirme, test, cache, async ve reactive seçeneklerini öğretmek. CORS / CSRF bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 70. Spring Testing

Unit, slice ve integration test seviyelerini destekler.
Spring TestContext Framework context yönetimi sağlar.
Amaç hızlı, güvenilir ve izole doğrulama yapmaktır.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Kimlik doğrulama, yetkilendirme, test, cache, async ve reactive seçeneklerini öğretmek. Spring Testing bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 71. JUnit Entegrasyonu

JUnit test runner ve assertion altyapısıdır.
@SpringBootTest, @WebMvcTest gibi annotation’larla Spring testleri çalıştırılır.
Test isimlendirme ve fixture düzeni bakım maliyetini etkiler.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Kimlik doğrulama, yetkilendirme, test, cache, async ve reactive seçeneklerini öğretmek. JUnit Entegrasyonu bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 72. Mockito

Mock nesnelerle bağımlılıkları taklit etmeyi sağlar.
Service unit testlerinde repository veya dış servis mocklanır.
Aşırı mocking tasarım kokusu olabilir; davranış değil sonuç test edilmelidir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Kimlik doğrulama, yetkilendirme, test, cache, async ve reactive seçeneklerini öğretmek. Mockito bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 73. Integration Testing

Birden fazla katmanın birlikte çalışmasını doğrular.
Testcontainers ile gerçek DB/Kafka gibi bağımlılıklar ayağa kaldırılabilir.
Yavaş olduğu için seçici ve kritik senaryolara odaklı yazılmalıdır.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Kimlik doğrulama, yetkilendirme, test, cache, async ve reactive seçeneklerini öğretmek. Integration Testing bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 74. Spring Cache

Sık kullanılan pahalı sonuçları tekrar hesaplamadan saklar.
@Cacheable, @CachePut, @CacheEvict temel annotation’lardır.
Cache invalidation ve tutarlılık stratejisi net tasarlanmalıdır.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Kimlik doğrulama, yetkilendirme, test, cache, async ve reactive seçeneklerini öğretmek. Spring Cache bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 75. Scheduling

Belirli zamanlarda çalışan işleri tanımlar.
@Scheduled cron, fixedDelay veya fixedRate ile kullanılır.
Cluster ortamında aynı job’ın birden fazla node’da çalışması kontrol edilmelidir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Kimlik doğrulama, yetkilendirme, test, cache, async ve reactive seçeneklerini öğretmek. Scheduling bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 76. Async Programming

Metotların ayrı thread üzerinde çalışmasını sağlar.
@Async ve TaskExecutor ile uygulanır.
Transaction context, exception handling ve thread pool sınırları bilinmelidir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Kimlik doğrulama, yetkilendirme, test, cache, async ve reactive seçeneklerini öğretmek. Async Programming bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 77. Spring Mail

SMTP üzerinden mail gönderimini kolaylaştırır.
JavaMailSender, MimeMessage ve template entegrasyonu kullanılır.
Production’da retry, queue ve rate limit düşünülmelidir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Kimlik doğrulama, yetkilendirme, test, cache, async ve reactive seçeneklerini öğretmek. Spring Mail bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 78. Spring WebSocket

Çift yönlü gerçek zamanlı iletişim sağlar.
Chat, canlı bildirim, dashboard update gibi senaryolarda kullanılır.
STOMP, broker ve güvenlik yapılandırması önemlidir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Kimlik doğrulama, yetkilendirme, test, cache, async ve reactive seçeneklerini öğretmek. Spring WebSocket bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 79. Spring WebFlux ve Reactive Programming

Non-blocking reactive web stack’tir.
Mono ve Flux tipleriyle asenkron veri akışı temsil edilir.
Yüksek eşzamanlılıkta faydalıdır; blocking kodla karıştırılırsa avantaj kaybolur.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Kimlik doğrulama, yetkilendirme, test, cache, async ve reactive seçeneklerini öğretmek. Spring WebFlux ve Reactive Programming bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.


# Boot, Cloud, AI ve Final Proje

Spring Boot, mikroservisler, observability, Spring AI ve uçtan uca üretim senaryosu.

## 80. Spring Boot'a Geçiş

Framework bilgisini koruyarak Boot’un auto configuration ve starter kolaylıklarına geçiştir.
Boilerplate azalır, embedded server ile hızlı deploy edilir.
Boot sihir değil, opinionated Spring yapılandırmasıdır.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Spring Boot, mikroservisler, observability, Spring AI ve uçtan uca üretim senaryosu. Spring Boot'a Geçiş bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 81. Auto Configuration

Classpath, bean varlığı ve properties’e göre otomatik bean yapılandırır.
Conditional annotation’lar temel mekanizmadır.
Hangi auto config’in devrede olduğunu actuator/conditions ile analiz edebilirsiniz.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Spring Boot, mikroservisler, observability, Spring AI ve uçtan uca üretim senaryosu. Auto Configuration bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 82. Starter Dependencies

İlgili kütüphane setlerini tek dependency altında toplar.
spring-boot-starter-web, data-jpa, security gibi starterlar yaygındır.
Versiyon uyumu Boot dependency management ile sağlanır.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Spring Boot, mikroservisler, observability, Spring AI ve uçtan uca üretim senaryosu. Starter Dependencies bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 83. Actuator

Production-ready health, metrics, info ve diagnostics endpointleri sağlar.
/actuator/health, /metrics, /env gibi endpointler kullanılabilir.
Güvenlik ve endpoint exposure ayarları production’da dikkat ister.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Spring Boot, mikroservisler, observability, Spring AI ve uçtan uca üretim senaryosu. Actuator bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 84. Spring Boot + REST + JPA Uygulaması

Boot starter web + data-jpa + validation ile hızlı REST projesi kurulur.
Entity, repository, service, controller ve DTO zinciri uygulanır.
Migration, logging, exception handling ve testler eklenince üretim kalitesi artar.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Spring Boot, mikroservisler, observability, Spring AI ve uçtan uca üretim senaryosu. Spring Boot + REST + JPA Uygulaması bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 85. Katmanlı Mimari

Uygulamayı sorumluluklara göre controller, service, repository gibi katmanlara ayırır.
Bağımlılıklar üstten alta akar; ters yönde sızıntı olmamalıdır.
Test, bakım ve ekip çalışması için temel mimari disiplindir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Spring Boot, mikroservisler, observability, Spring AI ve uçtan uca üretim senaryosu. Katmanlı Mimari bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 86. Controller – Service – Repository – Entity – DTO

Controller HTTP, service iş kuralı, repository veri erişimi, entity persistence modeli, DTO API modelidir.
Entity dış dünyaya doğrudan açılmamalıdır.
Bu ayrım güvenlik, versiyonlama ve validasyon esnekliği sağlar.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Spring Boot, mikroservisler, observability, Spring AI ve uçtan uca üretim senaryosu. Controller – Service – Repository – Entity – DTO bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 87. DTO / Mapper Yapısı

DTO dış API sözleşmesini, mapper entity-DTO dönüşümünü yönetir.
MapStruct veya manuel mapper kullanılabilir.
DTO kullanmamak entity sızıntısı ve lazy serialization hatası doğurabilir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Spring Boot, mikroservisler, observability, Spring AI ve uçtan uca üretim senaryosu. DTO / Mapper Yapısı bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 88. SOLID ve Clean Code

Single responsibility, open-closed, dependency inversion gibi prensipler Spring tasarımını güçlendirir.
Küçük service metotları, net interface ve anlamlı isimler bakım maliyetini düşürür.
Framework bilgisi clean code yerine geçmez; onu destekler.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Spring Boot, mikroservisler, observability, Spring AI ve uçtan uca üretim senaryosu. SOLID ve Clean Code bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 89. Design Patterns ile Spring

Factory, Proxy, Singleton, Template Method, Strategy gibi desenler Spring içinde sıkça görülür.
AOP proxy, JdbcTemplate template method, BeanFactory factory örnekleridir.
Desenleri tanımak framework davranışını daha hızlı kavratır.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Spring Boot, mikroservisler, observability, Spring AI ve uçtan uca üretim senaryosu. Design Patterns ile Spring bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 90. Logging

Uygulama davranışını izlenebilir hale getirir.
SLF4J facade, Logback implementasyonu yaygındır.
Correlation id, log level ve structured logging production için kritiktir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Spring Boot, mikroservisler, observability, Spring AI ve uçtan uca üretim senaryosu. Logging bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 91. Docker ile Spring Uygulaması

Spring uygulamasını container image olarak paketler.
Dockerfile, environment variables ve port mapping temel konulardır.
JVM memory ayarı, layer caching ve image boyutu production’da önemlidir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Spring Boot, mikroservisler, observability, Spring AI ve uçtan uca üretim senaryosu. Docker ile Spring Uygulaması bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 92. Production Deployment

Uygulamayı güvenli, izlenebilir ve ölçeklenebilir şekilde canlıya alma sürecidir.
Profile, secret, migration, health check, rollback ve monitoring planı gerekir.
CI/CD pipeline kalite kapılarını otomatikleştirmelidir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Spring Boot, mikroservisler, observability, Spring AI ve uçtan uca üretim senaryosu. Production Deployment bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 93. Spring Cloud'a Giriş

Dağıtık sistem problemleri için Spring tabanlı araçlar sunar.
Config, discovery, gateway, load balancing, circuit breaker gibi konuları kapsar.
Mikroservis mimarisinde operasyonel karmaşıklığı yönetmeye yardım eder.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Spring Boot, mikroservisler, observability, Spring AI ve uçtan uca üretim senaryosu. Spring Cloud'a Giriş bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 94. Microservices Mimarisi

Uygulamayı bağımsız deploy edilebilir küçük servisler halinde tasarlar.
Her servis kendi iş alanı ve verisine sahip olmalıdır.
Dağıtık transaction, gözlemlenebilirlik ve network hataları temel zorluklardır.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Spring Boot, mikroservisler, observability, Spring AI ve uçtan uca üretim senaryosu. Microservices Mimarisi bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 95. API Gateway

Client ile servisler arasında merkezi giriş noktasıdır.
Routing, auth, rate limit, logging ve cross-cutting policy uygular.
Gateway iş kuralı taşımaz; trafik ve policy katmanıdır.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Spring Boot, mikroservisler, observability, Spring AI ve uçtan uca üretim senaryosu. API Gateway bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 96. Service Discovery

Servislerin adreslerini dinamik olarak bulmasını sağlar.
Eureka, Consul veya Kubernetes service discovery kullanılabilir.
Dinamik ölçekleme ve instance değişiminde manuel URL yönetimini kaldırır.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Spring Boot, mikroservisler, observability, Spring AI ve uçtan uca üretim senaryosu. Service Discovery bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 97. Config Server

Dağıtık sistemlerde merkezi konfigürasyon yönetimi sağlar.
Git tabanlı config repository yaygın modeldir.
Secret yönetimi ve refresh stratejisi güvenli tasarlanmalıdır.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Spring Boot, mikroservisler, observability, Spring AI ve uçtan uca üretim senaryosu. Config Server bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 98. OpenFeign

Declarative HTTP client yaklaşımıdır.
Interface yazarak servisler arası REST çağrısı yapılır.
Timeout, retry, error decoder ve circuit breaker ile birlikte düşünülmelidir.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Spring Boot, mikroservisler, observability, Spring AI ve uçtan uca üretim senaryosu. OpenFeign bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 99. Circuit Breaker

Hatalı veya yavaş servise çağrıları kontrollü keser.
Fail fast, fallback ve yarı açık durumlarla sistemi korur.
Resilience4j Spring ekosisteminde sık kullanılan çözümdür.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Spring Boot, mikroservisler, observability, Spring AI ve uçtan uca üretim senaryosu. Circuit Breaker bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

## 100. Messaging – Kafka / RabbitMQ

Servisler arası asenkron iletişim sağlar.
Kafka yüksek hacimli event streaming; RabbitMQ queue/routing senaryolarında güçlüdür.
Idempotency, retry, dead-letter queue ve message schema kritik konulardır.

Ders anlatım notu: Bu başlık anlatılırken önce kavramın problemi netleştirilir. Ardından Spring'in bu problemi hangi soyutlama ile çözdüğü gösterilir. Son aşamada öğrenciye küçük bir kod parçası, gerçek proje senaryosu ve hata ayıklama örneği verilmelidir.

Neden önemli: Spring Boot, mikroservisler, observability, Spring AI ve uçtan uca üretim senaryosu. Messaging – Kafka / RabbitMQ bu hedefin parçasıdır; ezber değil, kurumsal Java uygulamasında bakım, test, güvenlik ve deployment kararlarını doğrudan etkileyen bir beceridir.

Sık hata: Annotation veya dependency eklemek tek başına çözüm değildir. Bean'in nerede üretildiği, hangi profile ile çalıştığı, proxy sınırlarının ne olduğu ve runtime'da hangi katmanda kullanıldığı mutlaka kontrol edilmelidir.

Uygulama önerisi: Bu konu için mini örnek; bir endpoint veya service sınıfı üzerinden önce yanlış/eksik yaklaşımı, sonra doğru Spring yaklaşımını göstermek şeklinde tasarlanmalıdır.

