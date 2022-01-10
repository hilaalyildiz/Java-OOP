
package akıllıcihazproje;

import java.util.Scanner;

public class MerkeziIslemBirimi {
    private IakıllıCihaz cihaz;
    private Ieyleyici eyleyici;
    private IsıcaklıkAlgılayıcı algılayıcı;
    private IagArayuzu arayuz;
    private IKullanıcı kullanici;
    
    public MerkeziIslemBirimi() {
        cihaz = new akıllıCihaz();
        eyleyici = new eyleyici();
        algılayıcı = new sıcaklıkAlgılayıcı();
        kullanici = new Kullanıcı();
    }
    
    public void baslangıc() {
        cihaz.bekleme("Kullanıcı bilgilerinizi giriniz: ");
        
        
        Scanner s = new Scanner(System.in);
        String ad = s.nextLine();
        
        if(kullanici.kullanıcıDogrula()){
            cihaz.bekleme("Sifrenizi giriniz : ");
            int sifre = kullanici.veriAl();
            if(sifre!=0){
                cihaz.bekleme("Sifreniz onaylandı, yapmak istediginiz islemi seciniz :");
                islemSecimi(); 
            }
        }
    }
    
    private void islemSecimi() {
        int secim;
        cihaz.kontrol();
        do {
            secim = kullanici.veriAl();
            switch(secim){
                case 1:
                    eyleyici.sogutucuAc();
                    break;
                case 2:
                    eyleyici.sogutucuKapat();
                    break;
                case 3:
                    agArayuzu.getInstance().sıcaklıkGonder();
                    break;
                case 4:
                    cihaz.kapatma("Cihaz kapatılıyor");
                    break;
                default:
                    cihaz.bekleme("Yanlıs secim yaptınız");
            }
        }
        while(secim!=4);
    }
    
    public int anaMenuyuGoster(){
        cihaz.bekleme("------ Ana Menu ------");
        cihaz.bekleme("1) Sogutucu Ac");
        cihaz.bekleme("2) Sogutucu Kapat");
        cihaz.bekleme("3) Mevcut Sıcaklıgı Goster");
        cihaz.bekleme("4) Kapat");

        return kullanici.veriAl();
    }
}
