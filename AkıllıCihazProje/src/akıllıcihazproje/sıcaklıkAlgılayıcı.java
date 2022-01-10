
package akıllıcihazproje;
import java.util.Random;

public class sıcaklıkAlgılayıcı implements IsıcaklıkAlgılayıcı {

    @Override
    public int sıcaklıkOku() {
        Random rand = new Random();
        int sıcaklık = rand.nextInt(30)+5;
        
        return sıcaklık;
    }
}
