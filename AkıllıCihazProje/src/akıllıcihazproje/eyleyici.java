
package akıllıcihazproje;

import java.util.Scanner;

public class eyleyici implements Ieyleyici {

    @Override
    public void sogutucuAc() {
        System.out.println("Sogutucu Çalıştırıldı");
        
        akıllıCihaz sıcaklık  = new akıllıCihaz();
        int mevcutSıcaklık = sıcaklık.sıcaklıkOku();
        int eksiDeger;
        
        if(mevcutSıcaklık>25) {
            System.out.println("Mevcut ortam sıcaklığı : "+ mevcutSıcaklık);
            System.out.println("Ortam kaç derece soğutulsun ?");
            
            Scanner s = new Scanner(System.in);
            eksiDeger = s.nextInt();
            mevcutSıcaklık = mevcutSıcaklık - eksiDeger;
            
            System.out.println("Mevcut ortam sıcaklığı : "+ mevcutSıcaklık);
            sogutucuKapat();
        }
            
    }

    @Override
    public void sogutucuKapat() {
        System.out.println("Sogutucu Kapatılıyor");
    }
    
}
