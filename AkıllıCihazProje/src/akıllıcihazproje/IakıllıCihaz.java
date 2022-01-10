
package akıllıcihazproje;

public interface IakıllıCihaz {
    public void bekleme(String mesaj);
    public void kapatma(String mesaj);
    public void algılama(String mesaj);
    int kontrol();
}
