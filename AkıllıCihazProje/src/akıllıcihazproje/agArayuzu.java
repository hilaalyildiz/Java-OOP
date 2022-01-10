
package akıllıcihazproje;

public class agArayuzu implements IagArayuzu {

    private static agArayuzu instance;
    private agArayuzu(){}
    
    public static synchronized agArayuzu getInstance(){
        if(instance==null)
            instance = new agArayuzu();
        return instance;
    }
    
    @Override
    public void sıcaklıkGonder() {
        sıcaklıkAlgılayıcı s = new sıcaklıkAlgılayıcı();
        int sıcaklıkDegeri = s.sıcaklıkOku();
        
        System.out.println("Mevcut sıcaklık degeri : "+sıcaklıkDegeri);
    }

}
