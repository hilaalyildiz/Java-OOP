
package akıllıcihazproje;

import java.util.Random;

public class akıllıCihaz implements IakıllıCihaz, IsıcaklıkAlgılayıcı {

    @Override
    public void bekleme(String mesaj){
        System.out.println(mesaj);
    }

    @Override
    public void kapatma(String mesaj) {
        System.out.println(mesaj);
    }

    public void algılama(String mesaj) {
        sıcaklıkAlgılayıcı s = new sıcaklıkAlgılayıcı();
        int sıcaklık = s.sıcaklıkOku();
        
        if(sıcaklık <25)
            System.out.println("Tavsiye edilen oda sıcaklığının altına düşüldüğü algılandı");
    }

    @Override
    public int kontrol() {
        MerkeziIslemBirimi m = new MerkeziIslemBirimi();
        m.anaMenuyuGoster();

        return 1;
    }

    @Override
    public int sıcaklıkOku() {
        Random rand = new Random();
        int sıcaklık = rand.nextInt(30)+5;
        
        return sıcaklık;
    }
    
}
