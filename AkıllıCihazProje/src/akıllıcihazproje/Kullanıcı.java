
package akıllıcihazproje;

import java.util.Scanner;
import java.sql.*;

public class Kullanıcı implements IKullanıcı {
    
    @Override
    public boolean kullanıcıDogrula() {
        System.out.println("Kullanıcı dogrulanıyor");
        return true;
    }

    @Override
    public int veriAl() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public boolean veritabaniBaglanti(String kullaniciAdi, String sifre)
    {
        boolean a=false;
        try
        {   /** Bağlantı kurulumu **/
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/akilliCihazVT",
                    "postgres", "12345");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");


            String sql= "SELECT*  FROM \"Kullanici\" WHERE \"KullaniciAdi\"='"+kullaniciAdi+"' AND  \"Sifre\"='"+sifre+"'";

            /** Sorgu çalıştırma **/
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);


            if(rs.next()) {
                System.out.println("Baglantiniz saglandi.");
                a=true;
            }

            /** Kaynakları serbest bırak **/
            rs.close();
            stmt.close();
            /** Bağlantı sonlandırma **/
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    public void girisleriKontrolEt()
    {
        Scanner input =new Scanner(System.in);
        System.out.println("Kullanıcı Adı Giriniz:");
        String username=input.nextLine();
        System.out.println("Şifre Giriniz:");
        String password=input.nextLine();
        if(!veritabaniBaglanti(username,password)){
            System.out.println("Yanlis kullanici adi veya sifre. Tekrar deneyin.");
            girisleriKontrolEt();
        }


    }
}
