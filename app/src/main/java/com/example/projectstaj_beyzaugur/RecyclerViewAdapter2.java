package com.example.projectstaj_beyzaugur;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.ViewHolder> {

    private List<String> itemList;
    private ItemClickListener itemClickListener;

    // ItemClickListener arayüzüne sahip bir nesne RecyclerViewAdapter2'e constructor aracılığıyla verilmeli
    public RecyclerViewAdapter2(List<String> itemList, CityDetailFragment cityDetailFragment) {
        this.itemClickListener = itemClickListener;
        this.itemList = itemList;
    }

    public void setData(List<String> itemList, ItemClickListener itemClickListener) {
        this.itemList = itemList;
        this.itemClickListener = itemClickListener;
        notifyDataSetChanged(); // Adapter'a verinin güncellendiğini bildirin
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item = itemList.get(holder.getAdapterPosition());
        holder.textView460.setText(item);
        holder.textView460.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedMekanAciklama = getMekanAciklamaForPosition(position); // Seçilen mekanın açıklamasını alın
                String selectedMekanAdress = getMekanAdressForPosition(position);
                Intent intent = new Intent(v.getContext(), PlaceDetailActivity.class);
                intent.putExtra("placeName", item); // Mekan adını ekleyin
                intent.putExtra("placeDescription", selectedMekanAciklama);
                intent.putExtra("placeAdress", selectedMekanAdress);
                // Mekan açıklamasını ekleyin
                v.getContext().startActivity(intent);

            }
        });


}


    @Override
    public int getItemCount() {
        return itemList != null ? itemList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView460;

        public ViewHolder(View view) {
            super(view);
            textView460 = view.findViewById(R.id.textView460);
        }
    }

    // ItemClickListener arayüzündeki metodu implemente ediyoruz
    public interface ItemClickListener {
        void onItemClicked(String itemName, int position);

    }

    private String getMekanAciklamaForPosition(int position) {
        if (itemList != null && position >= 0 && position < itemList.size()) {
            String selectedMekan = itemList.get(position);


            String mekanAciklama = "";

          //KONYA

            if (selectedMekan.equals("Mevlana Müzesi")) {
                mekanAciklama = "Mevlânâ Müzesi, Konya'da bulunan, eskiden Mevlâna'nın dergâhı olan yapı kompleksinde 1926 yılından beri faaliyet gösteren müzedir. \"Mevlana Türbesi\" olarak da anılır.\n" +
                        "\n" +
                        "Yeşil Kubbe yani Mevlana'nın türbesi dört kalın sütun (fil ayağı) üzerine yapılmıştır. O günden sonra farklı tarihlerde çeşitli eklemeler yapılmasıyla yapı genişlemiştir. Osmanlı sultanlarının bir kısmının Mevlevi tarikatından olması Türbe'ye özel bir önem verilmesini ve iyi korunmasını sağlamıştır.\n" +
                        "\n" +
                        "Müze alanı bahçesi ile birlikte 6.500 m² iken, yeri istimlak edilerek Gül Bahçesi olarak düzenlenen bölümlerle birlikte 18.000 m²ye ulaşmıştır. Müzenin bahçesinde yer alan I. Selim tarafından yaptırılan şadırvanın göbeğinin Germiyanoğulları Beyliği tarafından hediye edildiği söylenir.\n" +
                        "\n" +
                        "Ücretsiz olmadan önce, bağlı bulunduğu Kültür Bakanlığı'na en çok gelir getiren ikinci müzeydi.[kaynak belirtilmeli]\n" +
                        "\n" +
                        "Mevlana hakkında menkıbelerin anlatıldığı Ahmed Eflaki'nin kitabı \"Arifler'in Menkıbeleri\"nde Mevlana'nın babası için türbe yaptırmak isteyen devrin sultanına \"gök kubbeden daha görkemlisini yapamayacağınıza göre zahmet etmeyin\" dediği rivayeti yer alır. Türbe, Mevlana'nın ölümünden sonra inşa edilmiştir.";
            } else if (selectedMekan.equals("Karatay Medresesi")) {
                mekanAciklama = "Karatay Medresesi, II. İzzeddin Keykavus devrinde, 1250 " +
                        "- 1251 yıllarında yapılmıştır. Eyvanın solundaki kubbeli hücre Celaleddin Karatay'ın türbesi olduğundan ve Celalettin Karatay Vakfiyesine kayıtlı olduğundan Celalettin Karatay tarafından yaptırıldığı düşünülmektedir. Mimarı bilinmemektedir. Osmanlı devrinde de kullanılan medrese 19. yüzyılın sonlarında terk edilmiştir.\n" +
                        "\n" +
                        "Medrese, Selçuklular devrinde hadis ve tefsir ilimleri okutulmak üzere \"Kapalı Medrese\" tipinde Sille taşından inşa edilmiştir. Tek katlıdır. Giriş doğudan gök ve beyaz mermerden yapılmış kapı ile sağlanmaktadır. Kapı Selçuklu devri taş işçiliğinin şaheser bir örneğidir. Yazı ve desenlerle süslenmiştir. Kapının üzerinde medresenin yapımı ile ilgili kitabeler yer almaktadır. Kapının diğer yüzeylerine seçme ayet ve hadisler kabartma olarak işlenmiştir. Kapıdan, evvelce kubbe ile örtülü (şimdi üzeri açık) bir avluya, buradan da bir kapı ile medreseye girilir. Medrese salonunun üzeri, merkezinde fener bulunan ve mozaik çinilerle kaplı kubbe ile örtülüdür. Kubbe kasnağında, duvarların üst kısımlarındaki bordürlerde ve hücre kapıları üzerindeki panoda ayetler yazılıdır. Binanın batı yönünde bulunan beşik tonozlu eyvanın kemerinde besmele ve Ayet-el Kürsi yer almaktadır. Kubbeye geçiş elemanı olan üçgenlerde ise Muhammed, İsa, Musa ve Davud peygamberlerin isimleri ile dört halifenin (Ebu Bekir, Ömer, Osman, Ali) isimlerine yer verilmiştir.";

            } else if (selectedMekan.equals("KentPlaza AVM")) {
                mekanAciklama = " Kentplaza, Konya'nın uluslararası standartlara sahip tek alışveriş merkezidir. Sadece tüketim ihtiyaçlarının karşılanması değil, nüfusun ailesiyle vakit geçirmesi, eğlenmesi, spor yapması da gerekiyor.  Ayrıca Kentplaza, dünyanın her yerinden her yıl Konya'ya akın eden insanlar için Mevlana Müzesi çevresinde yer almaktadır. \n" +
                        "\n" +  "Alışveriş merkezinde 5.600 metrekarelik büyük bir eğlence parkı, bowling salonu ve 6.500 metrekarelik iki yüzme havuzlu büyük bir spor alanı bulunuyor. Ayrıca 11 salonlu sinema ve çocuklar için özel oyun alanı da bulunmaktadır. Alışveriş alanı 45.000 m2 ile en büyük alana sahiptir. Kapalı ve açık olmak üzere 1.750 araçlık otopark kapasitesine sahiptir. Alışveriş merkezinin tasarımında bina kütlesinin farklı malzemeleri ve cephe konfigürasyonları kullanılmıştır. Bina altı kattan oluşuyor: zemin katta mağazalar ve ATM'ler, birinci ve ikinci katlarda ise başka mağazalar bulunmaktadır. Eğlence bölgesi olarak adlandırılan en üst katta sinema bulunmaktadır.Cinemaximum , çocuk alanı ve gastronomi alanı.Projenin finansmanı beş yatırımcı Ramazan Biberci, Aslan Korkmaz, Selim Somuncu, Mehmet Ali Çiftçi ve Ahmet Arıcı tarafından sağlandı. Bu projeyi gerçekleştirmek için birlikte Deha AVM A.Ş.'yi kurdular. " ;

            } else if (selectedMekan.equals("KuleSite AVM")) {
                mekanAciklama = "Konya'da Nalçacı Dönüşüm Projesi kapsamında Konya eski otogarının yerine yapılan 163 m. boyunda, 42 katlı bir gökdelendir. Konya'nın ve İç Anadolu Bölgesi'nin en uzun gökdelenidir. Türkiye'nin 6. gökdeleni unvanına sahiptir. 2006 yılında hizmete girmiştir.\n" +
                        "Bina Konya'nın resmi araç plaka numarasının 42 olması sebebiyle 42 katlı inşa edilmiştir ve en üst iki katı, alt katlardan farklı olarak daire biçimindedirler. Bu 41. ve 42. katların restoran olarak değerlendirilip kendi eksenleri etrafında dönmesi planlanmaktadır. Ayrıca Konya'nın engebesiz coğrafi yapısının da katkısıyla bina Konya'nın her yerinden görülebilmektedir. \n " +
                        "\n" +  "Türkiye`nin en modern ve önde gelen alışveriş ve eğlence merkezlerinden biri olan Kulesite; Seha Yapı tarafından 11 ayda inşa edilerek, 2004 yılının Haziran ayında hizmete girmiştir. Kulesite, 130 markası ile Konya`nın modern yüzünün en görkemli yapısı olarak dikkat çekmektedir. Hafta içinde günlük ortalama 35 bin kişinin ziyaret ettiği Kulesite Alışveriş ve Eğlence Merkezi`nin hafta sonlarında da 45 bin kişi ziyaret etmektedir.Kulesite, toplam 9 salonlu ve 1500 koltuk kapasiteli Avşar Sinemaları, 1,421 m² -42 Buz Park Eğlence Merkezi, marka mağazaları, 7,776 m² 5M Migros hipermarketi, 1700 araçlık otoparkı, restoranları ve eğlence alanları ile Konya`da sosyal ve kültürel yaşamın merkezi konumundadır.";
            } else if (selectedMekan.equals("Selçuk Üniversitesi")) {
                mekanAciklama = " 1962'de MEB'e bağlı olarak açılan Selçuk Eğitim Enstitüsü ve Yüksek İslâm Enstitüsü ile üniversiteye sahip olma yolunda ilk ciddi adım atılmıştır. Bu ilk adımın güçlendirilerek geliştirilmesi için 1968’de Konya'da “Üniversiteyi Kurma ve Yaşatma Derneği” kurulmuş ve gösterilen üstün gayretler sonucu bugünkü Mühendislik-Mimarlık Fakültesi'kurulmuştur.  Üniversitenin kuruluşuna hazırlık safhası teşkil eden bu üç okuldan daha etkin bir üniversiteye geçiş süreci ise 1975 yılında gerçekleşmiştir. 11 Nisan 1975’te yürürlüğe giren “4 Üniversitenin Kurulması ile İlgili 1873 Sayılı Kanun” ile ülkemizde dört üniversitenin kurulması öngörülmüş ve Selçuk Üniversitesi de bu kanuna istinaden kurulmuştur.\n" +
                        "\n" +  " Selçuk Üniversitesi, “41 sayılı Kanun Hükmündeki Kararname” ile bir anda 8 fakülte, 4 yüksekokul ve 3 enstitü seviyesine ulaşmıştır. 2011 yılı Aralık ayında Bakanlar Kurulu kararıyla bir çok fakülte 'Necmettin Erbakan Üniversitesi'ne bağlanmıştır. Bugün bünyesinde 23 fakülte, 7 enstitü, 5 yüksekokul, 1 konservatuvar, 22 meslek yüksekokulu, 54 araştırma ve uygulama merkezi bulunan Selçuk Üniversitesi, altmış sekiz bini aşkın öğrencisi ile Türkiye’nin en büyük eğitim kurumları arasında yer almaktadır.";
            } else if (selectedMekan.equals("KTO Karatay Üniversitesi")) {
                mekanAciklama = "2005 yılında kuruluş çalışmalarına başlanan Konya Ticaret Odası (KTO) Karatay Üniversitesi, Konya Ticaret Odası Eğitim ve Sağlık Vakfı tarafından Konya’nın ilk vakıf üniversitesi olarak 2009 yılında açılmıştır. KTO Karatay Üniversitesi ilk öğrencilerini 2010-2011 eğitim-öğretim yılında kabul etmiş ve ilk mezunlarını Haziran 2013’te vermiştir.\n" +
                        "\n" +
                        "KTO Karatay Üniversitesi 2010 yılında 3 fakülte ile eğitim öğretime başlamış olup bugün itibarıyla 5 fakülte, 3 yüksekokul, 3 meslek yüksekokulu ve 1 enstitü ile ön lisans, lisans ve lisansüstü eğitim vermektedir. 2020-2021 eğitim öğretim yılında üniversitenin toplam öğrenci sayısı yaklaşık 9.000'dir.\n" +
                        "\n" +
                        "KTO Karatay Üniversitesi, Konya Ticaret Odası’nın üniversitesidir. Bu nedenle öğrenciler sanayi ve ticaret dünyası ile iç içe eğitim görmektedir. Öğrenim süresi boyunca stajlarını tamamlayan öğrenciler, sektörde aranılan özelliklere sahip bireyler olarak eğitimlerini tamamlamaktadır. Sektör Danışmanlığı Projesi ile de akademik danışman öncülüğünde, öğrencilerin eğitim alanları ile ilgili mesleki ve sektörel donanımı öğrencilikleri devam ederken kazanmaları hedeflenmektedir.";
            }else if (selectedMekan.equals("Selçuk Üniversitesi Tıp Fakültesi")) {
                mekanAciklama = "Selçuk Üniversitesi Tıp Fakültesi Selçuk Üniversitesi'ne bağlı bir tıp fakültesidir. Üniversitenin Meram Tıp Fakültesi'nden sonra kurulan ikinci tıp fakültesi olmuştur. Meram Tıp Fakültesi'nin 27.12.2011 tarihinde Bakanlar Kurulu Kararı ile Necmettin Erbakan Üniversitesi'ne bağlanmasından sonra üniversitesinin tek tıp fakültesi olarak kalmıştır.\n"+
                        "\n" +   " Öğrencileri 2009 yılına kadar Meram Tıp Fakültesi'nde eğitim görmüşlerdir. 2009'dan itibaren kendi yerleşkelerinde eğitimine devam etmişlerdir. Kasım 2001'de Selçuk Üniversitesi bünyesinde Selçuklu Tıp Fakültesi  adı altında ikinci bir Tıp Fakültesi 22 Kasım 2001 tarih ve 24591 sayılı Resmi Gazete'de yayınlanan Bakanlar Kurulu kararı ile kuruldu. 30 Eylül 2002 tarihinde fakülteyi kazanan ilk öğrenciler Meram Tıp Fakültesi'nde Eğitim-Öğretimlerine başladılar.Meram Tıp Fakültesi ile hiçbir bağı kalmayarak tamamen kendi öğrencileriyle,gelişmiş teknolojisi ile tıp doktorları yetiştirmeye başlamış aynı zamanda eğitim ve araştırma hastanesi ile de bölge halkına üst düzey hizmet vermeyi ilke haline getirmiştir.";
            }else if (selectedMekan.equals("Konya Numune Hastanesi")) {
                mekanAciklama= "Yakın tarihte İl Özel İdaresine bağlı Gureba Hastanesi olarak adlandırılan kuruluşlar bilinmektedir.\n" +
                        "1915 yılında kurulmuş olan Konya Gureba Hastanesi, hali hazırdaki Konya Numune Hastanesi yerleşkesinde kurulan ilk hastanedir. Ahşap bir barakada 10 (on) yatak kapasitesi ile açılmış olan Konya Gureba Hastanesi bugün 610 yatak kapasitesi ile Konya ili ve çevre illere hizmet veren sayılı sağlık tesislerinden biri haline gelmiştir. \n" +
                        "13 Aralık 2017 tarihinde yeni hastane binasının hizmete girmesiyle birlikte yıllık ortalama 1 milyona yakın insana ayaktan sağlık hizmeti sunmaya başlamış ve bu sayı her geçen gün artarak devam etmektedir. \n" +
                        "\n" +  " Selçuklu figürleriyle süslenen akıllı bina teknolojisi ile işletilen, tek ve iki kişilik, içerisinde tuvalet ve banyosunun bulunduğu odalarıyla 5 yıldızlı otel konforunda uzmanların tam not verdiği örnek bir projedir. 610 hasta yatağı, bin 300 araçlık 4 katlı kapalı ve açık otoparkları, 96 adet yoğun bakım yatağı, 120 adet poliklinik odası, 16 adet ameliyathanesi, Palyatif Bakım Merkezi, Toplum Ruh Sağlığı Merkezi, Diyaliz Merkezi, Geleneksel ve Tamamlayıcı Tıp Uygulama Ünitesi, Evde Sağlık Hizmetleri Merkezi, Sigara Bıraktırma Polikliniği, Göz Bankası, Kalp Hastalıkları Merkezi, İnme Ünitesi ve Yanık Ünitesi ile hastalarımıza çok yönlü sağlık hizmeti sunulmaktadır. Konya Numune Hastanesi, endokrinolojiden gastro cerrahisine, onkoloji cerrahisinden ve nefrolojiye kadar 28 ayrı dahili ve cerrahi branşta alanında uzman hekim ve sağlık çalışanları ile sağlık hizmeti sunumunu gerçekleştirmektedir.";
            }

            //TEKİRDAĞ

            else if (selectedMekan.equals("Süleymaniye Cami")) {
                mekanAciklama= "Süleymaniye Camisi, Tekirdağ ilinin Çorlu ilçesinde bulunmaktadır. 1521 yılında Kanuni Sultan Süleyman tarafından Mimar Acem Ali’ye inşa ettirilmiştir.\n"+
                        "\n" +      " Kare bir plana sahip olan cami, kesme taştan yapılmıştır. Süleymaniye Camisi, üzeri 3 kubbe ile örtülü olan 3 bölümlü, bir son cemaat yerine sahip olup bu cemaat yeri 4 sütunun yuvarlak kemerler ile birbirine bağlanması ile oluşturulmuştur. Üzeri pandantili, kasnaklı merkezi bir kubbe ile örtülü olan cami; taş kaideli, yuvarlak yivli gövdeli ve tek şerefeli, altı mukarnaslı olan bir minareye sahiptir. Süleymaniye Camisi’sinin avlusunda yuvarlak sütunların taşıdığı çatılı bir şadırvan bulunmaktadır.";
            }  else if (selectedMekan.equals("Çorlu Kalesi")) {
                mekanAciklama= "      Tarihi bir değer taşıyan Çorlu Kalesi, Tekirdağ ilinin Çorlu ilçesinde bulunmaktadır. Günümüze sadece bazı kalıntıları gelebilen Çorlu Kalesi’nin VI. yüzyıla ait olduğu tahmin edilmektedir.\n" +
                        "\n" +
                        "        Bizans döneminde yapılmış olup; kalenin doğu ve batısı dere yataklarıyla çevrelenmiştir. Sur duvarlarının yuvarlak kulelerle desteklendiği görülen Çorlu Kalesi, kesme taş temeller üzerine kurulmuştur. Tekirdağ’ın görülesi bir tarihi kalıntısı olan kale, askeri bir önem taşıdığı aşikardır. Tekirdağ tatilinizde ziyaret etmeniz gereken yerler oldukça fazladır.";
            }  else if (selectedMekan.equals("Tekira Alışveriş Merkezi")) {
                mekanAciklama= "TEKİRA Avm, bölgenin en büyük alışveriş merkezi, büyük markaların hemen hemen hepsi mevcut. Her kattan avmnin heryeri gözüküyor, oldukça ferah bir avm. \n"+
                        "\n" +    "Toplam 85 bin metrekare kapalı alana sahip dört katlı TEKİRA Avm' de 72 mağazanın yanı sıra bir süpermarket, 17 restoran-cafe, 7 sinema salonu ve 1200 araç kapasiteli ücretsiz otopark yer alıyor. 1.500 metrekare çocuk oyun alanı ile küçüklerin gözdesi olan TEKİRA Avm, engellilere özel olanakları gibi hizmetleri ile de memnuniyet elde ediyor.";
            }  else if (selectedMekan.equals("Çerkezköy Center")) {
                mekanAciklama= "Çerkezköy’ün tek modern alışveriş merkezi olan Çerkezköy Center AVM, 35,000m2’lik arsa üzerinde 13.000m2 brüt alan ile 2010 yılında Kipa olarak açılmıştır.\n"+
                        "\n" +     "2020-2022 arasındaki genişleme projesinin tamamlanması ile 32,000m2 brüt alanda Çerkezköy Center AVM olarak Çerkezköy-Kapaklı-Saray-Vize ilçelerine hizmet vermektedir.\n";
            }  else if (selectedMekan.equals("Tekirdağ Namık Kemal Üniversitesi")) {
                mekanAciklama= "Tekirdağ Namık Kemal Üniversitesi, 17 Mart 2006 tarih ve 26111 sayılı Resmî Gazete’de yayımlanan 5467 sayılı kanunla, Tekirdağ'da kurulan devlet üniversitesi. Üniversite, Trakya Üniversitesi'nin Tekirdağ çevresindeki yerleşkenin ayrılarak, yeni bir üniversite kurulmasıyla meydana geldi";
            }  else if (selectedMekan.equals("Tekirdağ Devlet Hastanesi")) {
                mekanAciklama= "Tekirdağ Memleket Hastanesi mutasarrıf Zekeriya Zihni Bey ile Mahalli Ahız Asker Reisi (Askerlik Şube Başkanı) Salim Paşa'nın teşebbüsleriyle Etyemez Mahallesi Kabristanı üzerine inşa edilmiştir. Hastanenin bütün masrafları Cemaat-ı İslamiye teşkilatı yani İslam Cemaatı tarafından karşılanmıştır. Çanakkale ve Gelibolu yarımadasında yapılan savaşlarda yaralanan Mehmetçikler Memeleket Hastanesinde ve o zaman kolordu merkezi olan bugün Tuğlacılar Lisesi ve Atatürk İlköğretim Okulu Arsaları üzerine kurulan seyyar çadırlarda tedavi ediliyor, iyi olanlar memleketlerine gönderiliyor. Şehit olanlar aynı yol üzerindeki Namazgah Kabristanına (bugünkü şehitlik) defnediliyordu. 1950 yılına kadar 50 yataklı bir hastane olarak çalışan Memleket Hastanesi 1960-1967-1972-1985-2002 yıllarında yapılan ek binaların açılışı ile 250 yatak kapasiteli olarak hizmet vermekte iken 2006 yılında 82. Yıl Devlet Hastanesi ile birleşerek 400 yatak kapasitesine çıkarılmıştır. Bugün 1. ve 2. kısım binalarıyla Tekirdağ Devlet Hastanesi olarak hizmet vermektedir.";
            }  else if (selectedMekan.equals("Çerkezköy Devlet Hastanesi")) {
                mekanAciklama= "Çerkezköy Devlet Hastanesi’nin inşaatı 1986 yılında başlamış olup,1990 yılında bitirilmiştir. Çerkezköy Dispanseri, 1990 yılının Kasım ayında yeni binasına taşınarak faaliyetine başlamış ve 25 Ağustos 1991 tarihinde de 32 yataklı Dispanser olarak açılışı yapmıştır. Açılıştan yaklaşık bir ay sonra 70 yataklı“Hastane “ statüsüne geçilmiştir.\n" +
                        "\n" +
                        "2016 yılında 204 yatak kapasitesi ile 31.700 metrekare kapalı alanda yeni hizmet binaya geçilmiştir. Hastanenin açılış aşamasında (16.05.2016) 204 yatak ile B grubu hizmet rolünde faaliyet göstermekteyken hızlı nüfus artışı ve ilçemizin ihtiyaçları göz önünde bulundurularak yapılan başvuru neticesinde;  Bakanlık Kamu Hastaneleri Genel Müdürlüğünün 24.12.2018 tarih ve E.3156 sayılı yazıları ile hastanenin hizmet rolü A2 olarak güncellenmiştir.\n" +
                        "\n" +
                        "Hastanenin ortalama hizmet nüfusu 450.000 olup; 2020 yılı başında yeni açılan 6 yataklı yoğun bakımla birlikte yatak sayısı 210’a çıkmış, Pandemi süreci ile birlikte Bakanlığımızın talimatları doğrultusunda açılan 35 yoğun bakım yatağımızla birlikte mevcut yatak sayımız 245’ e arttırılmıştır. Bölgenin ihtiyaçları doğrultusunda yapılan çalışmalar doğrultusunda yatak sayımızın 300’e çıkarılması için yapılan başvuru neticesinde yatak sayısı 2021 başında 300 olarak güncellenmiştir";
            }

            //SİVAS

            else if (selectedMekan.equals("Çifte Minareli Medrese")) {
                mekanAciklama= "Anadolu Selçuklu Sultanı I. Alaeddin Keykubad'ın kızı Hüdâvent Hatun tarafından 1253 yılında yaptırılmış olan bu tarihi yapı, Anadolu'nun en büyük sanat şaheserlerinden biridir. Hüdâvent Hatun'dan dolayı \"Hatuniye Medresesi\" olarak da adlandırılır\n" +
                        "Kümbeti Erzurum' da bulunan kümbetlerin en büyüğüdür. Her biri 26 metre yüksekliğindeki rengârenk çinilerle süslü çift minare, bu tarihi esere isim olmuştur. Avlulu, 2 katlı, 4 eyvanlı olup, 37 oda ve bir camiye sahiptir. 1.824 m² (38m x 48 m) lik bir alan üzerine kuruludur. Açık avlulu medreselerin Anadolu 'daki en büyük örneğidir.\n" +
                        "\n" +  " Kuzey cephedeki taçkapı tam bir sanat eseridir. Taçkapı formundan ziyade çeşme nişleri ile yarım yuvarlak iki payanda vardır. 16 oluklu, firuze renkli çini kakmalı tuğladan yapma minarelerin kürsüleri de dikkat çekicidir. Taçkapının iki yanından yükselen silindirik minareler, tuğla ve mozaik çiniler ile süslenmiştir. Medresenin ve iç kısımda bulunan kümbetin giriş kapıları başta olmak üzere; medrese mimarisinde yer alan önemli ve değerli parçalar, Rusların Erzurum’u işgali dönemlerinde Ruslar tarafından yerlerinden sökülerek Rusya'ya götürülmüştür. Buradan sökülen çini ve oyma taş motifler Leningrad müzesinde sergilenmektedir. Önceki dönemlerde Osmanlı Sultanı IV.Murat tarafından kapsamlı olarak tamir ettirilmiştir.Son dönemde kısmi zemin kayması ve yüzey aşınmaları ile ilgili olarak; 2011 yılında devlet katkılarıyla başlatılan kapsamlı restorasyon çalışmaları, 2015 yılı itibarıyla devam etmektedir";
            }  else if (selectedMekan.equals("Gök Medrese")) {
                mekanAciklama= "Gök Medrese ya da diğer adıyla Sahibiye Medresesi, Sivas'ta yer alan medresedir. Anadolu Selçuklu Devleti döneminde, batı yönünde giriş kapısının yer aldığı ana büyük kapı üzerindeki kitabesinden anlaşıldığına göre 1271 yılında Sahip Ata Fahrettin Ali tarafından Mimar Kaluytan'a (Kaluyan el-Konevi) yaptırılmıştır.\n" +
                        "Taç kapısının yan sütunca başlıkları üzerinde karşılıklı olarak yazılı imzaya göre Gök medresenin mimarı Konyalı Kaluyan'dır.\n" +
                        "\n" +
                        "Çifte minareli taç kapısı, ve kapının üzerindeki süslemeler, yapının en görkemli bölümüdür. Süslemelerde 9 tür hayvan başı, yıldız, ve hayat ağacı motifleri kullanılmıştır. Duvarları yontma kalker taşından yapılan medresenin minareleri 25 metre uzunluğundadır. Üzengi taşlarının üzerindeki süslemede koç, tilki, boğa, ördek, at, kuş, aslan, yılan ve fil olmak üzere dokuz adet hayvan başı vardır.Bazı araştırmacılar bu figürlerin 12 Hayvanlı Türk Takvimi ile bağlantılı olduğunu öne sürmüşlerdir.\n" +
                        "Gök Medrese açık avlulu dört eyvan şemasının uygulandığı iki katlı olduğu iddia edilen bir medresedir. Plastik sanatın şaheserlerinden olan taç kapıda mermer malzeme nedeniyle ışık gölge sistemi genel görünümünü etkilemektedir. Ayrıca sırlı tuğla ve mavi çini işçilikli tuğla örgülü minarelerde taç kapıya daha da önem kazandırmaktadır. Cephenin solunda üç dilimli kemeri, iki satırlık kitabesi ve üç yönü dolaşan geometrik bordürüyle çeşmesi cepheyi daha hareketlendirmiştir. Bu hareketliliği sağ ve sol tarafta benzemeli pencereler ve bekitme kuleler tamamlamaktadır. Medrese taç kapının üst iki köşesinde iç içe girmiş hayvan başları doldurmaktadır.\n" +
                        "\n" +
                        "Girişin solundaki kare planlı kubbeli oda ise Dar-ül Hadis bölümüdür. İç duvarları sıvanmıştır. Üzeri açık dikdörtgen planlı iç avlunun ortasında bir havuzu olması gerekir. Bugün yapının içinde bu havuzun mermer taşları hala durmaktadır. Anadolu’da bilinen en büyük Selçuklu havuzudur. 22 köşeli poligonil bir plana sahiptir. Avlunun kuzey ve güneyinde altı sütun üzerine inşa edilmiş bir revak kısmı bulunmaktadır. Bu revakların gerisinde küçük kapılardan hücrelere girilir. Doğu yönündeki ana eyvanı yıkılmış yerine mevcut taş ve kitabelerle bir duvar örülmüştür. Kuzey ve güneydeki yan eyvanların içi çini tezyinatla süslüdür.\n" +
                        "1934-1967 yılları arasında müze olarak kullanılmıştır.";
            }  else if (selectedMekan.equals("İvapark Avm Sivas")) {
                mekanAciklama= "Kentin ilk alışveriş merkezi İvapark, modern hayatın kolaylıklarını, yerel değerlerle birleştirerek, Sivas’ın zengin ve yaşayan kültürünün bir parçası olarak 14 Aralık 2016’da açılmıştır.\n" +
                        "Prestijli bir noktada, şehrin gelişen bölgesinde yer alan proje, ziyaretçilerini Selçuklu mimarisinin örneklerinden esinlenerek görkemli bir girişle selamlamaktadır. Davetkar girişlerin açıldığı 2 büyük meydanda kafeleri, yeşil alanları ve oturma grupları ile keyifli buluşma alanları sunmaktadır. Ortak alanlarda yer alan, iç bahçeleri ve teras alanları ile ferah ve konforlu bir ortamda ziyaretçilerini ağırlayan proje, doğal gün ışığı alacak şekilde planlanmıştır.\n" +
                        "35.000m² kiralanabilir alana sahip projede, süpermarket, yapı market, ulusal ve uluslararası markalar,restoranlar, eğlence alanları ve sinema yer almaktadır.2015 yılında İvapark projesi, International Property Awards’ta, Retail Development Kategorisinde Highly Commended ödülüne layık görülmüştür. Ayrıca aynı yıl Hürriyet Gazetesi tarafından düzenlenen Sign of the City Ödüllerinde, “İnşaat Aşamasındaki En İyi Alışveriş Merkezi” ödülünü almıştır.2017 yılında ise; Stevie Awards tarafından düzenlenen, International Business Awards’ta,“Gayrimenkul Kategorisi”nde Geçici Kiralama projesi ile Bronz Stevie Ödülü ile taçlandırılmıştır.\n" +
                        "Kiralanabilir Alan: 35.000 m² Mağaza Sayısı: 120 Otoparak Kapasitesi: 850 araç Açılış Tarihi: 14 Aralık 2016\n" +
                        "\n" +
                        "Sivas kentinin gelişen bölgesinde yer alan İvapark Alışveriş ve Yaşam Merkezi, 35.000 metrekare kiralanabilir alanı, ulusal ve uluslararası 120 markası ile Sivas’ın ilk ve tek alışveriş merkezi olarak hizmet veriyor.\n" +
                        "Sivas’ın yerel mimari dokusundan esinlenerek oluşturulan; modern çizgilerle kente değer katmak amacıyla kurgulanan İvapark, modanın önde gelen markaları, teknoloji, spor ve rahat giyim mağazaları, ev dekorasyon üniteleri, anne - bebek, çocuk mağazaları ve süpermarketi ile Sivas ve çevre illerden gelen ziyaretçiler için önemli bir çekim noktası.\n" +
                        "Zengin mağaza karması, etkinlikleri, mimarisi, kafe - restoranları, yeme - içme alanları, terasları, sineması, çocuk oyun alanı ile her yaştan ziyaretçi için keyifli bir yaşam alanı sunan İvapark, Sivas’ta yeni bir hayatın yolunu açıyor.";

            }  else if (selectedMekan.equals("Sivas Cumhuriyet Üniversitesi")) {
                mekanAciklama= "Sivas Cumhuriyet Üniversitesi (eski ismiyle Cumhuriyet Üniversitesi), Cumhuriyet'in kuruluşunun 50. yılı anısına, 9 Şubat 1974 tarihinde 1788 Sayılı Kanunla Sivas'ta 11000 dönüm arazi üzerinde kurulmuştur. 1974 yılında tıp fakültesi ile eğitime başlamıştır. Görevdeki rektörü Prof. Dr. Alim Yıldız'dır.\n" +
                        "\n" +
                        "Kampüs, Sivas merkezinden 5 km uzaklıktadır.[4] Kampüse ulaşım belediye otobüsleriyle sağlanmaktadır. Kampüsün içerisinde kütüphane, kafe, restoran, yurt, market, sağlık ocağı, spor salonu gibi kurum ve işletmeler de vardır.\n" +
                        "\n" +
                        "Temmuz 2021 tarihinde kayıtlı 46.294 öğrencisi vardır.";
            }  else if (selectedMekan.equals("Sivas Bilim ve Teknoloji Üniversitesi")) {
                mekanAciklama= "Sivas Bilim ve Teknoloji Üniversitesi 18.05.2018 tarihli ve 30425 sayılı Resmî Gazete’de 7141 sayılı Yükseköğretim Kanunu İle Bazı Kanun ve Kanun Hükmünde Kararnamelerde Değişiklik Yapılmasına Dair Kanun kapsamında kurulan 16 Üniversite arasında herhangi bir üniversiteden bölünme olmaksızın kurulmuştur. İlgili Kanunla Üniversitemizde 3 Fakülte, 1 Yabancı Diller Yüksekokulu, 1 Meslek Yüksekokulu ve 1 Enstitü kurulmuş; 300 akademik, 351 idari personel ihdas edilmiştir. Rektör ataması 27 Aralık 2018 tarihinde yapılmış ve kuruluş çalışmaları 2019 Ocak ayı itibarıyla başlamıştır.\n" +
                        "\n" +
                        "Ülkemizin ulusal kalkınma ve özellikle ulusal güvenliği ilgilendiren alanlarda dışa bağımlılığa son verip uluslararası rekabette hak ettiği yeri alması için gerçekleştirilen ulusal düzeydeki çalışmalar bağlamında Türk Yükseköğretim alanı da son yıllarda bir dizi yeni gelişmelere sahne olmuştur. Son olarak 2016 yılında Yükseköğretim Kurulu Başkanlığı tarafından üniversitelerin değişik tematik alanlar ve değişik misyonlarla yapılanmaları gerektiği düşüncesinden hareketle 15 üniversite bölgesel kalkınmada misyon odaklı çalışmalar için 11 Üniversite ise araştırma üniversitesi olarak belirlenmiştir.\n" +
                        "\n" +
                        "11. Kalkınma Planında belirlenen öncelikli üç gelişme alanından ikisi olan Tarım ve Savunma Sanayi alanları Kuruluş Kanunumuzda yer almış olan akademik birimlerle örtüşmektedir.";
            }  else if (selectedMekan.equals("Sivas Devlet Hastanesi")) {
                mekanAciklama= "Sivas SSK Hastanesi mevcut binasına 1971 yılında taşınmıştır. 2005 yılına kadar Sosyal Sigortalar Kurumuna bağlı bir hastane olarak değerli halkımıza hizmet vermiştir. 2005 yılında SSK Hastanelerinin Sağlık Bakanlığı’na devri ile Sivas Devlet Hastanesi olarak hizmet vermeye başlamıştır. 2016 yılında Numune Hastanesi ile birleştirilmiş, 2021 yılı Şubat ayında ayrılarak, yeniden Sivas Devlet Hastanesi olarak hizmet vermeye başlamıştır.\n" +
                        "Hastanemizin açık otopark alanında Bun Baba Türbesi bulunmaktadı";
            }  else if (selectedMekan.equals("Divriği Devlet Hastanesi")) {
                mekanAciklama= "Divriği Devlet hastanesi 1950 li yıllarda sağlık merkezi olarak  hizmete girmiştir,1974 ve 1992 yıllarında bünyesinde yapılan ek binalarla hizmet vermeye devam etmiştir.ilçemizde özellikle sonbaharda diyaliz hasta sayısının artması ve yaz aylarında  hasta sayısnın artması nedeni ile 2007 yılında bir ek bina daha yapılarak hemodiyaliz üniteleri kurulmuştur.\n" +
                        "\n" + "\n" +
                        "     Divriğili iş adamı Sadık Özgür tarafından yaptırılan ve temeli 19 Kasım 2009 tarihinde atılan 20 bin metrekare alana sahip Divriği Sadık Özgür Devlet Hastanesi\"nde yer döşemeleri ve duvar boyaları özel antibakteriyel malzemelerden yapılmış, her   odada tv, buzdolabı, refakatçi koltukları, dolap, banyosu içerisinde 56 adet hasta odası,24 saat sıcak su imkanı,merkezi güç kaynağı, mahkum odası, ibadethane, morg, çamaşırhane, kantin, 5 adet poliklinik,2 adet diş polikliniği,1 adet diş röntgen birimi,çocuk bakım ve emzirme odası, mutfak, kütüphane, konferans salonu, yemekhane,Anne oteli,12 dairelik lojman, 4 gözlem odası, 2 adet ameliyathane salonu, 4 yataklı yoğun bakım servisi, doğumhane ,merkezi sterilizasyon  ünitesi, kapalı ve açık  otopark , görme özürlüler için yönlendirme sistemi,4 araç kapasiteli özürlü otoparkı bulunuyor.";
            }


            //İSTANBUL

            else if (selectedMekan.equals("Galata Kulesi")) {
                mekanAciklama= "Galata Kulesi ilk olarak Bizans İmparatoru Justinianos tarafından MS 507-508 yılında inşa edilmiştir. Günümüzdeki kuleyi 1348 - 49 yılında Cenevizliler yeniden inşa etmiştir. Kule 1445 - 46 yılları arasında yükseltilmiştir. 1500'lü yıllarda depremden zarar görerek, Mimar Murad bin Hayreddin tarafından onarılmıştır. III. Selim döneminde kule onarıldıktan sonra, kulenin üst katına bir cumba eklenir. 1831'de kule bir yangın daha geçirir, II. Mahmut kulenin üzerine iki kat daha çıkar ve külah biçiminde olan ünlü dam örtüsüyle kulenin tepesi kapatılır. Yapı son olarak 1967'de onarım görmüştür.\n"+
                        "\n" +  "alata Kulesi yığma moloz taş örgü sistemde inşa edilmiştir. Dış cephe taş örgüdür. Girişteki kitabede 16 mısralık methiye II. Mahmut döneminde yapıldığı için onun adına yazıldığı düşünülmektedir.\n" +
                        "\n" +
                        "Kapının üzerindeki yuvarlak kemerli pencere askerlerin gözetleme yeri idi. Yüksek giriş katından sonra dokuz katlı bir yapıdır. Silindirik gövdesi üzerindeki pencereler tuğla örgülü yuvarlak kemerlidir. Külah çatının hemen altındaki son iki katın gelişimi silindirik gövdeyi çevreleyen profilli silmelerle vurgulanmıştır. Külah çatının altındaki katı sarmalayan, metal süslemeli şebekeli seyir balkonu mevcuttur. Alt katında ise derin nişli payelere oturan yuvarlak kemerler ve içerisinde tuğla örgü yuvarlak kemerli pencereler mevcuttur.\n" +
                        "\n" +
                        "Bugün yapının üçüncü kata kadar olan kısmının Ceneviz, diğer katlarının Osmanlı karakteri taşıdığı gözlenmektedir.";
            }  else if (selectedMekan.equals("Topkapı Sarayı")) {
                mekanAciklama= "İstanbul’un tarihine tanıklık eden ihtişamlı yapı Topkapı Sarayı, cihana hükmetmiş Osmanlı padişahlarına yüzyıllarca ev sahipliği yapmıştır. Günümüzde ise o dönemin hatıralarını yaşatan bir müze olarak hizmet vermektedir.\n" +
                        "\n" +
                        "Fatih Sultan Mehmet'in 1453 yılında İstanbul'u fethetmesiyle birlikte Osmanlı İmparatorluğu'nun yeni başkenti olan İstanbul'da devletin yönetimi için bir merkeze ihtiyaç vardı. Bu amaçla 1460 yılında inşasına başlanan Topkapı Sarayı, Fatih Sultan Mehmet’ten itibaren otuz birinci padişah Sultan Abdülmecid’e kadar yaklaşık dört yüz yıl süreyle imparatorluğun idare, eğitim ve sanat merkezi olarak kullanılmış, aynı zamanda padişahların evi olmuştur.\n" +
                        "\n" +
                        "3 Nisan 1924 yılında ise müze olarak hizmet vermeye başlayan Saray, bu özelliği ile Cumhuriyet’in ilk müzesi olarak tarihe geçmiştir.\n" +
                        "\n" +
                        "Günümüzde yaklaşık 300.000 arşiv belgesi, Osmanlı dönemine ait silah ve araç-gereçten oluşan ihtişamlı koleksiyonların, Kaşıkçı Elması gibi paha biçilemez hazinelerin yanı sıra kutsal emanetleriyle Topkapı Sarayı Müzesi, dünyanın en büyük saray müzelerinden biri konumundadır. Topkapı Sarayı’nın bölümleri 4 avlu ve 1 haremden oluşmaktadır. Saray, hizmet bölümü Birun ve iç örgütlenme yapılarını kapsayan Enderun olmak üzere 2 ana bölüme ayrılmıştır.\n";
            }  else if (selectedMekan.equals("Zorlu Center")) {
                mekanAciklama= "Zorlu Center, Zorlu Holding tarafından İstanbul'un Levazım bölgesinde inşa edilen çok amaçlı bir yapılar grubudur.\n" +
                        "\n" +
                        "2007 yılının Haziran ile Kasım ayları arasında gerçekleşen Zorlu Center Mimarlık ve Kentsel Tasarım Yarışması’na katılan 117 firmadan seçilen Emre Arolat Mimarlık ve Tabanlıoğlu Mimarlık Ortak Girişim Grubu’nun yürüttüğü tasarım çalışmaları 2007 yılında başladı. İnşaatı 2013’te tamamlanan proje kapsamında rezidans, ofis, otel (Raffles İstanbul), alışveriş merkezi ve performans sanatları merkezi (Zorlu PSM) yer alıyor.[1]\n" +
                        "\n" +
                        "2020'de 205 mağazasıyla 7 gün 10.00-22.00 arasında hizmet vermeye devam etmektedir.[2] Yerli ve yabancı mağazalara yer veren AVM alışverişin dışında haftanın her günü PSM'de (Performans Sanatları Merkezi) etkinlik gerçekleştiriyor.[3] Kentin \"buluşma noktası\" sloganıyla faaliyetlerine yeni açılan konsept mağaza ve restoranlarıyla devam ediyor.";

            }  else if (selectedMekan.equals("İstinye Park")) {
                mekanAciklama= "İstinye Park İstanbul’un Sarıyer ilçesinin Pınar mahallesinde yer alan bir alışveriş merkezidir. Maslak'a çok yakındır.\n" +
                        "\n" +
                        "2003'ün hemen başında Ömerler Mimarlık ve DDG Group tarafından tasarlanmasına ve proje çizimlerinin hazırlanmasına başlanan alışveriş merkezinnin inşaatına 2005'nin hemen başında başlandı. 2007’nin Mart ayında tamamlanan İstinye Park’ın resmi açılışı 19 Ekim 2007 günü yapıldı.[1] Bu projenin diğer alışveriş merkezlerinden ayıran genel özelliklerinden birisi alışveriş mağazalarının bir kısmının açıkhavada yer almasıdır. Diğer ayırıcı özelliği ise spesifik konularda uzmanlaşmış satış bölümlerinin yer aldığı pazaryeri konseptinin kullanılmasıdır.[2]\n" +
                        "\n" +
                        "Yaklaşık olarak 300 mağaza ve 90.000 m2 alışveriş merkezinde aynı zamanda 3.200 araç kapasiteli otoparkı bulunuyor. İnşaatında 600 bin metreküp hafriyat, 20 bin 500 ton inşaat demiri, 156 bin metreküp beton, 430 bin metrekare betonarme kalıbı, 194 bin metrekare döşeme kaplaması, 2,7 km korkuluk, 21 bin metrekare cephe kaplaması kullanıldı. 45.000 metrekare taban alanına sahip olan yapıda 64 adet yürüyen merdiven bulunuyor. 12 adet sinema salonu diğer alışveriş merkezlerininden farklı olarak binanın alt katlarında yer alıyor.\n" +
                        "\n" +
                        "Aynı zamanda alışveriş merkezinin hemen yanında İstinye Park Sitesi bulunmaktadır.";
            }  else if (selectedMekan.equals("İstanbul Teknik Üniversitesi")) {
                mekanAciklama= "1773 yılında kurulan Mühendishane-i Bahrî-i Hümâyûn, III. Mustafa döneminde mühendislik eğitimi vermek için askeri bir okul olarak kuruldu. Amacı güverte subayı ve gemi inşa subayı yetiştirmek olan okul, Osmanlı İmparatorluğu'nun batı referanslı ilk eğitim kurumlarından biriydi. 1795 yılında ise topçu ve istihkam subayı yetiştirmek amacıyla Mühendishane-i Berrî-i Hümâyûn kuruldu ve daha sonra okulun sivil kanadı olan Hendese-i Mülkiye oluşturuldu. Mühendishane'nin askeri kanadı günümüzde Kara Harp Okulu ve Deniz Harp Okulu olarak devam ederken, sivil kanadı da İTÜ'yü oluşturmuştur.\n" +
                        "\n" +
                        "İTÜ bugün  4'ü İstanbul'un Avrupa, 1'i Anadolu yakasında, 1'i de Kıbrıs'ta olan toplam 6 yerleşkeye yayılmıştır. Maçka, Taşkışla ve Gümüşsuyu yerleşkelerinde Osmanlı döneminden kalan binalarda hâlâ eğitim yapılmaktadır."+
                        "Türkiye'de ilk kez televizyon yayınlarının yapılması, ilk üniversite radyosunun kurulması, ilk kez bir üniversitede bilgisayar kullanılması, ilk defa bir Türk üniversitesinin uzaya uydu göndermesi; ilk yerli haberleşme uydusu, ilk yerli helikopter ve ilk yerli insansız otomobilin yapılması gibi mühendislik alanında Türkiye'deki birçok ilk İTÜ tarafından gerçekleştirilmiştir. İTÜ bugün bünyesindeki 13 fakülte, 39 bölüm ve 6 enstitü ile 25.294 civarında lisans, 11.331 civarında lisansüstü, 3.716 civarında doktora öğrencisi ve 2.241 civarında akademik personel ile eğitim hayatını sürdürmektedir. İTÜ tarafından yayınlanmış verilere göre akademik personel başına 17 öğrenci düşmektedir. Türkiye'deki pek çok üniversiteden farklı olarak kuruluşunda inşaat, mimarlık, makine ve elektrik olarak 4 fakülteye ayrılmıştır. İTÜ paydaşı pek çok hoca ve mezun TÜBİTAK bilim ödülü ve TÜBA ödülü almıştır ve pek çok hoca da ABD, İngiltere, Rusya bilimler akademisi üyesidir";
            }  else if (selectedMekan.equals("Marmara Üniversitesi")) {
                mekanAciklama= "Marmara Üniversitesi, İstanbul'da bulunan bir devlet üniversitesidir. Türkiye’nin önde gelen yükseköğretim kurumlarından biridir. Üniversite bünyesinde 16 fakülte, 11 enstitü, 3 yüksekokul ve 4 meslek yüksekokulu bulunmaktadır. Akademik birimlerinde Türkçe, İngilizce, Fransızca, Almanca ve Arapça olmak üzere beş dilde eğitim verilmektedir.\n" +
                        "\n" +
                        "Marmara Üniversitesi İstanbul’un Anadolu yakasına dağılmış 7 yerleşkede faaliyet göstermektedir. Bunlar Acıbadem, Anadoluhisarı, Bağlarbaşı, Başıbüyük, Göztepe, Kartal ve Dragos yerleşkeleridir. Anadolu yakasında toplam 2.985.627,97 m² olan yerleşkeler içinde alan itibarıyla en büyüğü 2.637.168,97 m² (181,7 dönüm) ile Maltepe Başıbüyük Recep Tayyip Erdoğan Külliyesi'dir. Göztepe Yerleşkesi 164.636,00 m² ve Anadoluhisarı Yerleşkesi 121.991,00 m² büyüklüktedir. En küçük yerleşke olan Kartal Yerleşkesi 1.000 m² büyüklüktedir.\n" +
                        "\n" +
                        "2020 üniversite mezunlarının iş bulma endeksine göre Marmara Üniversitesi 7. sırada yer almıştır. Listede üniversitenin 76 akademik programı birinci, 60 akademik programı ilk üç sırada yer almıştır. Ayrıca, Listede ilk sırayı Marmara Üniversitesi Ekonomi ve Kamu Yönetimi, İlahiyat, Eğitim, Hukuk, Medya ve Basın mezunları aldı.[3]\n" +
                        "\n" +
                        "İstanbul'un en hareketli bölgelerinden biri olan Kadıköy'de bulunan üniversiteye toplu taşıma ve özel ulaşımın yanı sıra üniversite hizmetleriyle de kolayca ulaşılabilir. İstanbul metrosunun M4 hattı üzerinde yer alan Göztepe metro istasyonu ve Marmaray Feneryolu istasyonu üniversitenin ana kampüsüne ulaşılabilmektedir.";
            }  else if (selectedMekan.equals("Beykoz Devlet Hastanesi")) {
                mekanAciklama= "Hastanemiz 1955 yılında S.S.K. Dispanseri olarak hizmete başlamıştır.1962 yılının Temmuz ayında 241 ruhsatlı yatak kapasitesiyle S.S.K. Paşabahçe Hastanesi olarak hizmete devam etmiştir.1970 yılı başlarında kurumun Okmeydanı ve Göztepe Hastaneleri açılana dek Eğitim Hastanesi düzeyinde hizmet vermiştir.\n" +
                        "1971 yılında Okmeydanı ve Göztepe Eğitim Hastanelerinin açılması ile S.S.K. Paşabahçe Hastanesi olarak hizmete devam etmiştir. 1985-1991 yılları arasında önce yeni poliklinik, laboratuar ve radyoloji birimleri açılmış daha sonra ünitemize ek bina ve hizmet alanlarının ilavesiyle ruhsatlı yatak sayımız 453'e çıkmıştır.\n" +
                        "6.Ocak.2005'te kabul edilen, 19.Ocak 2005'te yürürlüğe giren 5283 sayılı Bazı Kamu Kurum ve Kuruluşlarına ait Sağlık Birimlerinin Sağlık Bakanlığı'na devredilmesine dair Kanun uyarınca 19.Şubat 2005'ten itibaren İstanbul Paşabahçe Devlet Hastanesi olarak hizmete devam etmiştir.\n" +
                        "1 Ağustos 2009 tarihinden itibaren, Beykoz Devlet Hastanesi ile Paşabahçe Devlet Hastanesi tek başhekimlik altında birleştirilerek hizmetlerin Beykoz Devlet Hastanesi adı altında yürütülmesine\" karar verilmiştir\" ''BEYKOZ DEVLET HASTANESİ TEPEÜSTÜ EK HİZMET BİRİMİ ''olarak hizmete devam etmektedir.\n" +
                        "Halen faaliyetlerini Sağlık Bakanlığı' na bağlı olarak İstanbul Beykoz Devlet Hastanesi isimi ile sürdürmektedir. İstanbul Beykoz Devlet Hastanesi T.C. Sağlık Mevzuatına tabidir ve bu kanun ve yönetmeliklere uygun olarak çalışmaktadır. Hak sahibi olarak tanımladıklarımız, tedavi talebinde bulunan hastalar veya sahiplerini, tanı talebinde bulunan hastalar veya sahiplerini, herhangi bir nedenle sağlık kontrolü amacıyla gelen şahısları, sosyal güvenlik kurumlarını, resmi veya özel diğer kuruluş ve hastaneleri kapsamaktadır. Kalite Yönetim Sistemimiz, yukarıda sayılan hak sahiplerine odaklanarak tasarlanmıştır. Hastanemizde hastaların ve çalışanların beklentilerini daha iyi karşılayacak koşulları sağlamak için gerek altyapıya gerekse hizmet çeşitliliğine ve kalitesine yönelik çalışmalar yürütülmektedir.\n" +
                        "Hastanemizde hastaların ve çalışanların beklentilerini daha iyi karşılayacak koşulları sağlamak için gerek altyapıya gerekse hizmet çeşitliliğine ve kalitesine yönelik çalışmalar yürütülmektedir.\n" +
                        "26.04.2011 tarih 18851 sayılı Sağlık Bakanlığı onayı ile Beykoz Devlet Hastanesi adını almıştır.\n" +
                        "\n";
            }else if (selectedMekan.equals("Üsküdar Devlet Hastanesi")) {
                mekanAciklama= "Hastanemiz 01.12.1950 tarihinde Polis Prevantoryumu olarak hizmete açılmıştır. 09.09.1969 tarihinde Polis Hijyen ve Diyetetik Sağlık Merkezi, daha sonrada\n" +
                        "Sağlık ve Sosyal Yardım Bakanlığı’nın 13.07.1975 tarihli onayları ile 200 yataklı hastane şekline dönüştürülmüştür. 1978 yılında da Polis Hastanesi ismini almıştır.\n" +
                        "\n" +
                        "1980 tarihinde inşaatına başlanan ana bina 15.01.1985 tarihinde resmen hizmete açılmış olan hastane 1985-87 tarihleri arasında yalnız meslek mensupları\n" +
                        "ve bakmakla yükümlü oldukları kişilere hizmet verirken daha sonra teşkilat emeklileri, eş ve çocukları ile sivil hastalara da hizmet vermeye başlamıştır.Polis Hastanesi Yaptırma ve Yaşatma Derneğinin katkıları ile modern hale getirilen hastanemiz  konferans salonu Üsküdar Devlet Hastanesi adını aldıktan sonra\n" +
                        "pek çok toplantı,eğitim, seminer ve sempozyuma ev sahipliği yapmıştır.\n" +
                        "\n" +
                        "19.02.2005 tarihinde 5283 sayılı kanun ile Emniyet Genel Müdürlüğü İstanbul Polis Hastanesi Sağlık Bakanlığına devredilerek İstanbul Üsküdar Devlet Hastanesi adını almıştır.\n" +
                        "Aynı tarihte SSK Genel Müdürlüğüne bağlı Doğancılar SSK Dispanseri Üsküdar Devlet Hastanesi Semt Polikliniği olarak hastaneye bağlanmıştır.27 Haziran 2008 tarihinde  “Bebek Dostu Hastane” unvanını alan hastanemiz, Sağlık Bakanlığı’nın 01.08.2009 tarihinde aldığı karar ile daha önce 29 Mayıs 1927’de\n" +
                        "Validebağ Öğretmenler Hastanesi olarak açılmış olan Validebağ Devlet Hastanesi ile birleştirilerek tek çatı altında Üsküdar Devlet Hastanesi olarak hizmet vermeye başlamıştır.\n" +
                        "İstanbul Anadolu Kuzey Kamu Hastaneleri Birliği’nin 01.06.2016 tarihli kararı ile Validebağ Ek Hizmet Binası Haydarpaşa Numune Eğitim ve Araştırma Hastanesi’ne devredilmiş\n" +
                        "aynı tarihlerde Çamlıca Semt Polikliniği hastanemize bağlanmıştır. Bu tarihten itibaren merkez bina ve iki Semt Polikliniğimizle hastalarımıza hizmet vermeye devam edilmektedir.";
            }
            //  ANKARA

            else if (selectedMekan.equals("Anıtkabir")) {
                mekanAciklama= "Atatürk bir devri açıp yeni bir düzeni getirdikten sonra 10 Kasım 1938'de öldüğünde, geçici olarak Etnografya Müzesi'ne defnedildi. Uygun bir anıt yeri aranmasına hemen başlandı ve Ankara'nın kente egemen bir tepesi olan Rasattepe uygun görüldü. Anıtkabir'in projesi bir yarışmayla belirlendi. Bu amaçla açılan yarışmada Emin Onat ve Orhan Arda'nın projesi başarılı görülerek uygulanmasına karar verildi.\n" +
                        "\n" +
                        "Anıtkabir bugünkü adı Anıttepe olan yerde 15 bin metrekarelik bir alanda yapıldı. Yapımında Çankırı'nın açık sarı ve gri travertenleri kullanıldı.\n" +
                        "\n" +
                        "Anıtkabir bütün Türklerin sevgisinin, saygısının bütünleştiği bir simgedir. Başlangıç noktasındaki İstiklal ve Hürriyet kulelerinden, iki yanında Hüseyin Özkan'ın 24 Hitit aslanının yer aldığı Aslanlı Yoldan, Mehmetçik, Müdafaa-i Hukuk, Cumhuriyet, Zafer, İnkılap, Misak-ı Milli, Barış ve 23 Nisan kulelerinin çepeçevre sarmaladığı Zafer Alanı'na kadar her nokta, Türk'ün verdiği bağımsızlık ve özgürlük savaşını anlatır. 32 x 60 metre boyutlarında ve 20 metre yüksekliğinde, duvarları ve döşemesi koyu renkli Bilecik mermerleriyle kaplı, tavanı altın mozaikle süslü Büyük Salon'un gizemli havası ise insanı, acılarla, gözyaşlarıyla dolu savaş yıllarına götürür. Salonun giriş kapısının karşısında, penceresi Ankara Kalesi'ne bakan duvarın önündeki taş bir set üstünde tek parça mermerden oluşan simgesel bir lahit vardır. Atatürk'ün naaşı, lahdin tam altındaki toprak mezardadır.\n" +
                        "\n" +
                        "Bu görkemli salondan çıkıldığında, sol yanda İnkılap ve Misak-ı Milli kuleleri arasındaki galeri, 1960'da açılan Atatürk Müzesi'dir. Burada Atatürk'ün özel eşyaları, giysileri, madalyaları, fotoğraflan, kendisine sunulan armağanlar, Atatürk'le ilgili belgeler sergilenmektedir. Ayrıca 1967'de kurulan Atatürk Kitaplığı da İnkılap Kulesi'ndedir. Atatürk'ün Çankaya'daki özel kitaplığı buraya nakledilmiştir.\n" +
                        "\n" +
                        "Anıtkabir'in birçok duvarında Atatürk'ün bazı söylevlerinden bölümler ve özdeyişler yazılıdır. Birçok yerlerini de Zühtü Müridoğlu, Şadi Çalık, Ali Hadi Bara, İlhan Koman ve Nusret Su-man kabartma ve heykellerle süslemişlerdir. Ana yapıya giriş kapısının solunda Atatürk'ün Gençliğe Hitabı, sağ yanında da Gençliğin Cevabı bulunmaktadır.\n" +
                        "\n" +
                        " Atatürk'ün arkadaşlarından, Türkiye'nin ikinci Cumhurbaşkanı İsmet İnönü'nün mezarı da, ana yapının tam karşısındaki, Barış ve Zafer kulelerinin arasında yer almaktadır";
            }  else if (selectedMekan.equals("Ankara Kalesi")) {
                mekanAciklama= "Ankara Kalesi, Ankara'nın Altındağ ilçesinde bulunan tarihi bir kale. Ne zaman yapıldığı kesin olarak bilinmemekle birlikte M.Ö. 5. yüzyıl başında Galatların Ankara'ya yerleşmeleri sırasında kalenin var olduğu bilinmektedir. Romalılar, Bizanslılar, Selçuklu Hanedanı ve Osmanlılar dönemlerinde birçok kez onarımdan geçmiştir. Ankara Kalesi dışarıdan görümüne göre daha büyüktür. Her yıl çeşitli festivallerede ev sahipliği yapmaktadır.\n" +
                        "Kale tarih içinde çeşitli dönemler yaşamıştır. MÖ 2. yüzyıl başında Romalıların Galatya'yı işgalinden sonra kent büyüyerek kale dışına taştı. Roma İmparatoru Caracalla MÖ 217'de kalenin surlarını onarttı. MÖ 222 - 260 arasında İmparator Alexander Severus, Perslere yenilince kale kısmen tahrip edildi. 7. yüzyılın 2. yarısından sonra Romalılar kaleyi onarmaya başladı. Bizans döneminde İmparator II. Justinianos MS 668'de dış kaleyi yaptırmıştır, İmparator III. Leon 740'ta kale duvarlarını onarırken iç kale surlarını yükseltmiştir. Bunun ardından İmparator I. Nikiforos 805'te, İmparator I. Basileios 869'da bu kaleyi onarmıştır. Kale 1073 yılında Selçuklu Hanedanının eline geçmiştir. 1101 yılında Haçlılarca ele geçirilen kale 1227 yılında tekrar Selçuklu Hanedanının hakimiyetine girmiştir. I. Alâeddin Keykubad kaleyi yeniden onartmış, 1249'da ise II. İzzeddin Keykavus kaleye yeni ilaveler yapmıştır. Osmanlı döneminde 1832'de Kavalalı İbrahim Paşa tarafından onarımdan geçirilmiş, kalenin dış duvarları genişletilmiştir.e ev sahipliği yapmaktadır.";
            }  else if (selectedMekan.equals("Kızılay AVM")) {
                mekanAciklama= "Uzun yıllar boyunca tamamlanamayan inşaatıyla meşhur olan alışveriş merkezinin projesi, 1980 yılında Affan Yatman tarafından çizildi. Çeşitli anlaşmazlıklar sebebiyle temeli ancak 1993 yılında atılabilen bina, 1999 yılında yap-işlet-devret yöntemiyle 25 yıllığına bir firmaya kiralandı. Fakat 2001 yılında ülke genelinde yaşanan ekonomik kriz sebebiyle inşaat çalışmalarına tekrar ara verilince, bu süreçte firma ile proje sahibi Türk Kızılayı davalık oldu. 2003 yılında, şirketle olan sözleşme iptal edildikten sonra uzun süre atıl halde bekleyen binanın yapımına ancak 2009'da devam edilebildi. İki yıllık bir çalışmanın ardından nihayetinde 2011 yılında bütün detayları tamamlanan yapı, aynı yılın Aralık ayında alıveriş merkezi olarak hizmete girdi.\n" +
                        "Tamamlanmasının ardından alışveriş merkezi olarak kullanılmaya başlanan bina, aslında bir ticari kompleks olarak tasarlanmıştı. Yapının bulunduğu noktada daha önceden Kızılay Parkı ve Türk Kızılayı'nın merkez binası bulunmaktaydı. Fakat bu bina yıkıldığı için yenisinin yapılması kararlaştırılarak bir yarışma açıldı. Yarışmayı ise Yatman'ın projesi kazandı. Eskiden burada bir meydan olduğu için bu ruhu korumak isteyen mimar, binanın girişini yayaların rahatça yürüyebileceği bir toplanma alanı olarak tasarladı. Ayrıca; binanın Kızılay tarafından kullanılacağı düşünüldüğü için de kan alma ünitelerinin yerleştirilebileceği şekilde planlanmıştı. Günümüzde yemek katı olarak hizmet veren en üst kısım ise çok amaçlı toplantı salonu olarak dizayn edilmişti. Esasen bir alışveriş merkezi için uygun olmayan binada bu yüzden sonraları birçok değişiklik yapıldı. Yaklaşık 7.000 metrekare arsa üzerine inşa edilen yapı, 37.988 metrekare kullanım alanına sahiptir.";

            }  else if (selectedMekan.equals("Metromall AVM")) {
                mekanAciklama= "Metromall AVM, Ankara'da bulunan bir alışveriş merkezidir. 28 Eylül 2017 tarihinde açılışı yapılmıştır. 198 mağazaya ve 3.000 araçlık otoparka sahip olan bina kompleksi Ankara'nın üstü açılabilen ilk alışveriş merkezidir.[1] Açılışın yapıldığı gece Hande Yener, sonraki hafta ise Murat Boz ve Ebru Gündeş sahne almıştır.\n" +
                        "50.000 metrekarelik bir arsa üzerine toplam kullanım alanı 450.000 metrekare olacak şekilde inşa edilen alışveriş merkezi, 6 katı bodrum, 1 katı zemin olmak üzere toplamda 8 katlıdır. Yapının alttan ilk üç katı sadece otopark olarak kullanıma açılmış, toplamda 88.000 metrekarelik kapalı otopark alanı elde edilmiştir. Araziler arasındaki kot farkından yararlanma amacı gözetilerek tasarlanan binaya farklı katlardan \n" +
                        "girişler bulunmakta ve böylece kesintisiz bir yaya akışı sağlanmaktadır.\n" +
                        "Binanın dış mimarisinde açılır-kapanır bir cam çatı tercih edilmiş, içeride olduğu kadar dış yüzeylerde de ahşap malzemeler kullanılmıştır. Cam tavan tasarımı sayesinde iç mekanda daha ferah bir ortam yaratılmış ve aynı zamanda enerji tasarrufu yapılması sağlanmıştır. Peyzaj düzenlemesi yapılırken havuzların, yeşil alanların ve doğal taşların yapının çeşitli yerlerinde sıkça kullanılması sayesinde de hareketlilik ve sakinlik aynı anda yakalanmıştır.";
            }  else if (selectedMekan.equals("Orta Doğu Teknik Üniversitesi")) {
                mekanAciklama= "Orta Doğu Teknik Üniversitesi (ODTÜ) (İngilizce: Middle East Technical University, METU), 15 Kasım 1956 tarihinde, zamanın Türkiye Başbakanı Adnan Menderes, Karayolları Genel Müdürü Vecdi Diker ve bir grup akademisyen tarafından Ankara'da kurulmuş bir devlet üniversitesidir. Mersin'de bulunan Deniz Bilimleri Enstitüsü ve KKTC'de bulunan ODTÜ KKK (Kuzey Kıbrıs Kampüsü) dışında bütün binaları aynı kampüstedir. Bugüne kadar 120 binin üzerinde mezun veren üniversitenin eğitim dili İngilizce'dir.\n" +
                        "\n" +
                        "Yabancı dilde eğitim vermek, merkezî bilgisayar sistemi kurmak, üniversite müzesi açmak, teknokent kurmak, internet bağlantısı gerçekleştirmek gibi ülke çapında birçok ilki gerçekleştirmiştir. 2014'te Times Higher Education Dünya Üniversite Sıralaması'nda 85. sırada yer alan ODTÜ, bu listede ilk yüze girebilen tek Türk üniversitesidir.";
            }  else if (selectedMekan.equals("Hacettepe Üniversitesi")) {
                mekanAciklama= "Hacettepe Üniversitesi (HÜ), 8 Temmuz 1967 tarihinde, 892 sayılı kanun ile Türkiye Cumhuriyeti'nin başkenti Ankara'da kurulmuş olan köklü bir devlet üniversitesidir. Merkez kampüsü Sıhhiye'de, en büyük yerleşimi ise Beytepe Kampüsü'nde olan üniversitenin toplamda beş adet yerleşkesi bulunmaktadır. Sıhhiye ve Beytepe dışındaki kampüslerde çeşitli meslek yüksekokulları ve araştırma merkezleri bulunmaktadır. 2019 yılında Ankara Devlet Konservatuvarı binasının da Beytepe Kampüsü'ne taşınması sonucunda Beşevler'deki kampüs tamamen boş kalmıştır. 2020 yılı itibarıyla üniversitenin rektörü, 24 Haziran 2020 tarihinde Cumhurbaşkanlığı tarafından atanmış olan Prof. Dr. Mehmet Cahit Güran'dır.";
            }  else if (selectedMekan.equals("Ankara Bilkent Şehir Hastanesi")) {
                mekanAciklama= "Ankara Bilkent Şehir Hastanesi, Ankara'nın Çankaya ilçesine bağlı Üniversiteler mahallesinde bulunan şehir hastanesidir. 2019 yılında açılan hastane, toplam 3.704 yatak kapasitesiyle Ankara Etlik Şehir Hastanesi'nden sonra Türkiye'nin ve Ankara'nın en büyük 2. hastanesidir.\n" +
                        "\n" +
                        "Hastanenin €890 milyon tutarındaki maliyeti sekiz yerli ve yabancı banka tarafından finanse edildi. Temeli 18 Eylül 2013'te atılan hastanenin inşaatı 2015'te başladı. Hastane kamu-özel iş birliği ile inşa edildi. Hastanenin bazı bölümleri Ekim 2018'de açıldı. Resmî açılışı ise 14 Mart 2019'da gerçekleştirildi. Şubat-Mayıs 2019 arasında Ankara Atatürk Eğitim ve Araştırma Hastanesi, Türkiye Yüksek İhtisas Eğitim ve Araştırma Hastanesi ve Ankara Numune Hastanesi kapatılarak hastalar, tıbbi cihazlar ve personel Ankara Şehir Hastanesi'ne taşındı.\n" +
                        "\n" +
                        "Çankaya ilçesinin Bilkent semtinde yer alan hastane, 180 dekar alan üzerine kuruludur. Hastanede 131 ameliyathane, 904 poliklinik ile 82 VIP oda, 1.554 tek yataklı oda, 725 çift yataklı oda ve 700 yoğun bakım ünitesinde toplam 3.704 yatak vardır. Diyaliz kliniği 38 yataklıdır. Hastane tam kapasite çalıştığında günde 30.000 hastaya hizmet verecek ve 8.000 acil servis hastasınını tedavi edecektir. Hastanede kalp ve damar cerrahisi, nöroloji, onkoloji, ortopedi ve genel dal birimleri vardır. Hastane, ülkedeki 20 şehir hastanesi arasında en büyük 2. hastanedir. Hastanede ayrıca tıbbi gözlem kliniği işlevi gören 100 yataklı bir otel ve ambulans helikopterlerin iniş yapabilmesi için iki heliport bulunur. Hastanede yaklaşık 2.700 akademisyen, doktor ve cerrah, 6.300 sağlık personeli ve 4.000 idari ve destek personeli istihdam edilmektedir.";
            }
            else if (selectedMekan.equals("Ankara Etlik Şehir Hastanesi")) {
                mekanAciklama= "Ankara Etlik Şehir Hastanesi ya da Ankara Etlik Entegre Sağlık Kampüsü, Ankara'nın Yenimahalle ilçesine bağlı Varlık mahallesinde bulunan şehir hastanesidir. 2022 yılında açılan hastane, toplam 4050 yatak kapasitesiyle Türkiye'nin en büyük şehir hastanesidir.\n" +
                        "\n" +
                        "Şehir hastanelerinin alt yapıları oluşturulmaya 2005'te başlandı. Etlik Şehir Hastanesi bunlardan biriydi. Haziran 2011'de ihaleyi Türkerler Holding aldı. Şehir hastanesinin temeli 22 Ekim 2013'te atıldı. Temmuz 2019'da inşaatında çalışan işçiler, ücretlerini alamadıkları için iş bıraktı. İddiaya göre işçiler iş bırakınca inşaatı durdu. Ocak 2021'de inşaatı yeniden başlandı. Haziran 2021'de açılması planlanan şehir hastanesi başka bir tarihe ertelendi. Etlik Şehir Hastanesi'ne Etlik Zübeyde Hanım Kadın Doğum EAH, Dr. Abdurrahman Yurtaslan Onkoloji EAH, Dışkapı Yıldırım Beyazıt EAH, Dr. Sami Ulus Kadın Doğum ve Çocuk Sağlığı EAH, Ulucanlar Göz Eğitim ve Araştırma Hastanesi 17 Ağustos 2022'de taşındı. Sağlık Bakanı Fahrettin Koca son hazırlıklar dolayısıyla Etlik Şehir Hastanesi'nde incelemelerde bulundu. 28 Eylül 2022'de Cumhurbaşkanı Recep Tayyip Erdoğan tarafından hizmete açıldı.\n" +
                        "\n" +
                        "Ankara Etlik Şehir Hastanesi, Kamu ve Özel işbirligi anlaşmasına istinaden yapılan bir hastane projesidir. Bu proje 3.624 yatak (+100 yataklı klinik otel) kapasitesi, 1,1 milyon m² üzerinde kapalı alanı ve 1,1 milyar Avro yatırım değeri ile dünyanın en büyük hastane projeleri arasında yer almaktadır.\n" +
                        "\n" +
                        "Etlik Şehir Hastanesi’ne açılması düşünülen hastaneler; kadın hastalıkları ve doğum; çocuk sağlığı ve hastalıkları; kardiyoloji ve kardiyovasküler cerrahi; onkoloji; ortopedi ve nörolojik bilimler ve de genel amaçlıdır.";
            }

            //  ANTALYA

            else if (selectedMekan.equals("Aspendos")) {
                mekanAciklama= "Aspendos veya Belkıs, Antalya ili Serik ilçesinde bulunan Belkıs köyünde yer alan antik tiyatrosuyla meşhur bir antik kenttir. Pamfilya'nın en zengin şehirlerinden birisidir.\n" +
                        "\n" +
                        "Aspendos, Serik ilçesinin 8 kilometre doğusunda, Köprüçayı'nın dağlık bölgesinden düzlüğe ulaştığı yerde M.Ö. 10. yüzyılda Akalar tarafından kurulmuş ve antik devrin mamur zengin kentlerinden biridir. Buradaki tiyatro M.S. 2. yüzyılda Romalılar tarafından inşa edilmiştir. Kent biri büyük, biri küçük iki tepe üzerine kurulmuştur.\n" +
                        "\n" +
                        "Coğrafyacı Strabon ve Pamponrus Mela-(Pomponius Mela), Kentin Agruslularca kurulduğunu yazarlar. Bölgeye MÖ 1200'den sonra Yunan göçleri olmuştur oysa Aspendos adının kaynağı Rumlardan önceki yerli Anadolu dilidir. Önemli bir ticaret yolu üzerinde olduğu ve Köprüçay Irmağı ile limana bağlandığı için Aspendos, her çağda ele geçirilmek istenen kentler arasında yer almıştır. Antik Kent Aspendos İ.Ö. 5. Yüzyıl ilk çeyreğine kadar Pers hakimiyetinde idi. Şehrin yakınlarında akan nehrin kenarında İ.Ö. 467 yılında Yunanlarla Persler arasında geçen, Eurymedon Savaşı adıyla anılan savaşta Yunanlar kazanmıştı.\n" +
                        "\n" +
                        "Aspendos'un en önemli yapısı tiyatrosudur. Antik tiyatrolar arasında en iyi şekilde korunarak gelmiş bir açık hava tiyatrosudur. Bu tiyatro Anadolu'daki Roma tiyatrolarının günümüze sahnesi ile ulaşabilen en eski ve sağlam bir örneğidir. Mimarı Aspendos'lu Theodorus'un oğlu Zenon'dur. Antonius Pius zamanında yapımına başlanmış Marcus Aurelius zamanında tamamlanmıştır (138-164). Tiyatro, kentin yerli tanrıları ile imparator ailesine sunulmuştur.\n" +
                        "\n" +
                        "Bir de Aspendos Antik Tiyatrosu'nun küçük bir öyküsü var. Aspendos kralının bir zamanlar herkesin evlenmek istediği çok güzel bir kızı vardır. Kral kızını kime vereceğini bilemediği için halka, \"Kim halkımız, kentimiz için en yararlı şeyi yaparsa kızımı ona vereceğim\" diye duyurur. Bunun üzerine iki ikiz kardeş iki büyük yapı yaparlar. Biri kente çok uzaklardan, karmaşık yolları birçok zorluğu geçerek, su getiren su kemerleri; öteki ortasında yere metal para atıldığında üst sıralardan bile sesinin duyulduğu dünyanın akustik olarak en iyi tiyatrosudur. Kral su kemerlerini gördükten sonra kızını su kemerlerini yapana vermek ister. Bunun üzerine tiyatronun mimarı Zenon krala bir oyun oynar. Kral tiyatronun üst sıralarında gezerken bir fısıltı duyar: \"Kral kızını bana vermeli.\" Akustiğe hayran kalan kral kızını büyük bir kılıçla ikiye ayırır ve kardeşlere verir.";
            }  else if (selectedMekan.equals("Köprülü Kanyon")) {
                mekanAciklama= "Köprülü Kanyon, Isparta'nın Sütçüler ilçesinde başlayan ve Antalya'da denize dökülen, rafting yapmaya uygun bir Köprüçay'ın vadisi.\n" +
                        "\n" +
                        "Rafting yapılabilen bölgenin başlangıcında iki adet de tarihi köprü bulunmaktadır, küçüğü asıl usta tarafından, kemerli büyük köprü ise ustanın kalfası tarafından inşa edilmiştir. Köprülü Kanyon ismini de bu köprülerden almıştır.\n" +
                        "\n" +
                        "Yaz aylarında günde 7 bin kişiye rafting imkânı sağlayan bu temiz nehrin suyu da kaynağından rahatlıkla içilebilir. Çevrenin tabii güzelliği iyi bir sayfiye yeri olmasında önemli rol oynamaktadır. Bu nedenle kanyon aynı zamanda turistik bir yerdir.\n" +
                        "\n" +
                        "Köprülü Kanyonun başlangıcı Ispartanın güney doğusunda bulunan Kasımlar beldesidir. Nehrin asıl kaynağını Ispartanın ilçesi olan Aksudan gelen ırmak ve yine Ispartaya bağlı Karacahisar köyünden çıkan su oluşturmaktadır. Kanyon Kasımlardan Antalyanın Değirmenözü köyüne kadar yaklaşık 25 km boyunca dar vadilerden oluşmaktadır. Bu kısımda özellikle suyun yükseldiği zamanlarda yürüyerek geçiş zordur. Ama yaz aylarında yürüyerek geçiş yapılabilir . Değirmenözü köyünden sonra nehir tamamen açık alanda akar. Daha sonra nehir tekrar dar vadilere girer. Bu ikinci kısım Köprülü Kanyon Antik Köprüsüne kadar devam eder.Yine bu bölümde dik vadiler zor geçişler ve doğal güzellikler vardır. Akarsu çevresinde 1973 yılında, 36.614 ha büyüklüğünde Köprülü Kanyon Millî Parkı oluşturulmuştur.";
            }  else if (selectedMekan.equals("Mark Antalya AVM")) {
                mekanAciklama= "\n" +
                        "Moda, eğlence, lezzet ve teknoloji için atan kalplere tam 55.000 m2 kiralanabilir alanda hizmet veren MarkAntalya Alışveriş Merkezi’nde aralarında Antalya’da ilk defa yer alan markaların da bulunduğu 155 mağaza bulunuyor.\n" +
                        "\n" +
                        "Lezzet dolu fast food ve restoranlarıyla ziyaretçilerine seçkin alışverişin ve nitelikli eğlencenin keyfini sunan MarkAntalya Alışveriş Merkezi modern mimari tasarımı, teras alanları ve 3.000 araçlık otoparkıyla alışveriş sonrasını da keyfe dönüştürmeye devam ediyor.";

            }  else if (selectedMekan.equals("TerraCity AVM")) {
                mekanAciklama= "Antalya'nın premium Alışveriş Merkezi TerraCity, ulusal ve uluslararası marka ve dünyaca ünlü markaları ilk kez Antalya’ya taşıdı. Alışveriş konseptine yeni bir boyut kazandıran TerraCity, 180 mağaza ve restoranları ile Antalya'nın en ilgi çekici yaşam merkezi haline geldi. TerraCity, modern mimarisi, eğlence alanları, ünlü markaları ve 1000 kişilik yeme içme alanı ile benzersiz bir konseptte eğlence ve alışveriş ortamı sunuyor\n" +
                        "Yenilikçi tarzıyla gayrimenkul sektöründe prestijli projeler geliştiren Eriapartners, Aytek Şavkan tarafından 2007’de kurulmuş gayrimenkul yatırım ve geliştirme firmasıdır. Şirket, çalışma ve yaşam alanlarını harmanlayarak yüksek kalite standartlarında estetik, fonksiyonel, “kent simgesi” niteliğinde gayrimenkul projeleri geliştirme misyonuyla kurulmuştur. Eriapartners, gayrimenkul projelerinde, arsanın alımından, mimari ve mühendislik tasarım ve planlamalarına, inşaatın yönetiminden projenin pazarlanması ve satışına uzanan, mülk yönetimi ile devam eden tüm süreçleri geliştirir; belirlenen hedefler doğrultusunda projeyi izler ve denetler.";
            }  else if (selectedMekan.equals("Akdeniz Üniversitesi")) {
                mekanAciklama= "Akdeniz Üniversitesi, Antalya'da kurulu bir devlet üniversitesidir. 20 Temmuz 1982 yılında Batı Akdeniz bölgesi Antalya’da kurulmuştur. Türkiye'nin köklü üniversitelerinden biridir. Kampüsünün geniş ve yeşil bir araziye sahip olması ve Konyaaltı Sahili'ne 15 dakikalık mesafede olması ile Boğaziçi Üniversitesi'nden sonra Türkiye'nin en güzel ikinci kampüsü seçilmiştir.\n" +
                        "\n" +
                        "Akdeniz Üniversitesi, Isparta’daki birimlerini 1992 yılında kurulan Süleyman Demirel Üniversitesine; Burdur’daki birimlerini 2006 yılında kurulan Mehmet Akif Ersoy Üniversitesine; Alanya’daki birimlerini ise 2015 yılında kurulan Alanya Alaaddin Keykubat Üniversitesine devretmiştir.\n" +
                        "\n" +
                        "Tıp Fakültesi, Hukuk Fakültesi, Turizm Fakültesi ve İktisadi ve İdari Bilimler Fakültesi ile ülkenin önde gelen öğretim kurumlarından biridir. İlk yüz naklinin yapıldığı üniversite, tıp tarihinde bir devrim yaratmıştır. Türkiye'nin en iyi 7. devlet üniversitesidir. Akademik çalışmaları baz alındığında en çok akademik makale veren 5. üniversitedir. Kamu Personeli Seçme Sınavı kapsamında elde ettiği başarı Türkiye ortalamasının üstündedir.\n" +
                        "\n" +
                        "24 fakülte, 7 enstitü, 3 yüksekokul, 1 konservatuvar, 12 meslek yüksekokulu ile 57 adet araştırma ve uygulama merkezinde eğitim ve araştırma faaliyetlerine devam etmektedir. Ayrıca Avrupa Üniversiteler Birliği ve Kafkasya Üniversiteler Birliği üyesidir.\n" +
                        "\n" +
                        "2021-22 eğitim-öğretim yılında 21513 ön lisans, 37389 lisans, 3893 yüksek lisans ve 1540 doktora öğrencisi olarak toplamda 64335 öğrenci öğrenim görmekteydi. 2022 yılı itibari ile üniversite kapsamında 540 profesör, 314 doçent, 491 doktor, 674 öğretim görevlisi ve 810 araştırma görevlisi olmak üzere toplam 2829 akademik personel görev yapmaktaydı.";
            }  else if (selectedMekan.equals("Antalya Bilim Üniversitesi")) {
                mekanAciklama= "Antalya Bilim Üniversitesi (eski adı ile Uluslararası Antalya Üniversitesi) 21 Temmuz 2010 tarihli Resmî Gazete kararıyla Antalya'da kurulmuş olan ikinci üniversite ve ilk vakıf üniversitesidir. Antalya Bilim Üniversitesi, Gaye Eğitim Sağlık Spor ve Çevre Vakfı tarafından kurulmuştur. 2012-13 eğitim öğretim dönemine öğrenci alımına başlayan üniversitenin rektörü Prof. Dr. İsmail Yüksek'dir.\n" +
                        "\n" +
                        "Resmî Gazete haberine göre; 6 fakülte (İktisadi ve idari bilimler, Mühendislik, Turizm, Hukuk, İletişim ve Güzel sanatlar ve mimarlık), 4 yüksekokul (Sivil havacılık, Yabancı diller, Adalet meslek yüksekokulu ve Meslek yüksekokulu) ve 2 enstitüden (Sosyal bilimler, Fen bilimleri) oluşacaktır. Okula ulaşım özel servislerle ve toplu taşıma ile sağlanmaktadır. Eğitim dili İngilizcedir. Okulda 83 ülkeden öğrenciler bulunmaktadır. İlk mezunlarını 2017'de vermiştir.\n" +
                        "\n" +
                        "Şu an merkez kampüste bir rektörlük, iki eğitim binası ve 1 yurt binası ile şehir yerleşkesinde ise hazırlık bölümü ve yüksek lisans ile hizmet vermektedir. Kız yurdu merkez kampüs içinde, erkek yurdu okulun bulunduğu Döşemealtı ilçesindedir.\n" +
                        "\n" +
                        "2021-22 eğitim-öğretim yılında 1260 ön lisans, 3714 lisans, 546 yüksek lisans ve 4 doktora öğrencisi olarak toplamda 5524 öğrenci öğrenim görmekteydi. 2022 yılı itibari ile üniversite kapsamında 47 profesör, 19 doçent, 120 doktor, 63 öğretim görevlisi ve 38 araştırma görevlisi olmak üzere toplam 287 akademik personel görev yapmaktaydı.";
            }  else if (selectedMekan.equals("Antalya Eğitim ve Araştırma Hastanesi")) {
                mekanAciklama= "Antalya Devlet Hastanesinin temeli 1918 yılında İtalyanlar tarafından atılmış olup, 1920 yılına kadar İtalyan Hastanesi adı altında hizmet vermiştir. 1925 yılında 1 başhekim, 3 doktor, 30 yatak kapasiteli Gureba Hastanesi, 1930 yılında Özel İdareye geçerek Memleket Hastanesi adını almıştır. Dahiliye ve cerrahi servisleri ile hizmet veren hastaneye, 1935 yılında Doğum ve Kadın Hastalıkları Servisi de eklenerek 1952 yılında yatak sayısı 90'a, 1968 yılında ise 200'e çıkarılmıştır.\n" +
                        "\n" +
                        "1970'li yılların başında, yeni hastane projesine ağırlık verilmesi nedeniyle yenileme yapılamayan mevcut binanın, yetersiz kaldığı görülerek kapsamlı bir tadilat ve yenileme hareketi başlatılmasına karar verilmiştir. Maddi imkanların, bir yardım derneği kurularak arttırılması için, Antalyalı hayırseverlerin desteği alınmıştır. Hastanenin fiziksel ve donanımsal yenilenmesini amaç edinen Antalya Devlet Hastanesi Güçlendirme Derneği kurulmuştur. Yardımsever insanların görülmemiş bir içtenlikle sağladıkları kaynaklarla tıbbi alet ve cihaz eksikleri tamamlanmış, 1985 yılı sonlarına kadar Antalya ve çevresine o günlerin koşullarıyla en iyi sağlık hizmeti sunulmuştur.\n" +
                        "\n" +
                        "1985-2007 yılları arası hizmet veren Antalya Devlet Hastanesi binasının 1970 yılında 400 yatak kapasiteli olacak şekilde yapımına başlanmış ve 15 yıllık inşaat süresinden sonra 1985 yılı ortalarında hizmete girmiştir. Ayrı bir binada hizmet veren 125 yataklı Doğum Evi ise, 1986 yılında kapatılarak Devlet Hastanesi bünyesine dahil edilmiş, hastanenin kadrolu yatağı da 525 'e çıkarılmıştır. Yatak kapasitesinin artan nüfusa göre yetersiz kalması nedeniyle binaya yapılan ilavelerle, 1997 yılında kadrolu yatağı 600'e çıkarılmıştır. 2005 yılındaki fiili yatak sayısı ise 625 olmuştur.    ";
            }
            else if (selectedMekan.equals("Kepez Devlet Hastanesi")) {
                mekanAciklama= "Antalya Kepez Devlet Hastanesi’ nin temeli 21.04.2014 tarihinde atılmış olup, 21.07.2016 tarihinde A2 rolünde 388 yataklı ‘Antalya Kepez Devlet Hastanesi’ adı altında tescillenmiştir.\n" +
                        "\n" +
                        "İlk olarak 26.12.2016 tarihinde Acil Servis ile hasta kabulüne başlanmış, 02.01.2017 tarihinde ameliyathanesi hizmete girmiştir. Şubat 2017’ de ikinci servisi de açılarak servisler Dahili ve Cerrahi Birimler olarak ayrılmıştır.\n" +
                        "\n" +
                        "Hastanemizin resmi açılışı 25.03.2017 tarihinde <3Cumhurbaşkanımız Sayın Recep Tayyip ERDOĞAN<3' ın katılımıyla yapılmıştır.\n" +
                        "\n" +
                        "Hastanemiz 52.000 m² arsa üzerine 53.500 m² kapalı alana sahip, üç ana bloktan oluşmaktadır.\n" +
                        "\n" +
                        "Temmuz 2018 tarihinde kapasitesi 400 yatak olarak arttırılan hastanemiz,  41 uzmanlık dalında klinik ve 5 ayrı 3. Seviye Erişkin Yoğun Bakım, bir izole Erişkin Yoğun Bakım,  bir Koroner Yoğun Bakım, bir 3. Seviye yeni doğan yoğun bakım ünitesi ve bir 1. Seviye yeni doğan yoğun bakım ünitesi ile yataklı tedavi hizmeti vermektedir. Klinik servislerimizde 219 hasta odası bulunmakta, bunların 109 çift kişilik, 97 tek kişilik ve 13 adet süit odası şeklindedir. Bünyesinde, 13 ameliyat odası bir Diyaliz Ünitesi ve en son teknoloji ile donatılmış görüntüleme yöntemleri ile hizmet vermektedir. Toplamda 400 yatağı bulunmakta olan hastanemiz modern mimarisi, konforlu ve güvenli hasta odaları ve yaşam alanlarıyla bölgenin en iyi ve en modern hastanelerinden birisidir. ";
            }

            //  BURSA

            else if (selectedMekan.equals("Bursa Ulu Camii")) {
                mekanAciklama= "ABursa Ulu Cami, Bursa’da I. Bayezid tarafından 1396-1400 yılları arasında yaptırılmış ulu camidir.\n" +
                        "\n" +
                        "Bursa’nın tarihi sembollerinden olan cami, Bursa kent merkezinde, Atatürk Caddesi üzerindedir. Çok ayaklı cami şemasının en klasik ve anıtsal örneği sayılır. Yirmi kubbeli yapı, Türkiye’deki iç cemaat yeri en geniş camidir. Mimarın Ali Neccar veya Hacı İvaz olduğu sanılmaktadır. Caminin kündekari tekniği ile yapılmış minberi Selçuklu oyma sanatından Osmanlı ahşap oymacılığı sanatına geçişin en önemli örneklerinden biri kabul edilen değerli bir sanat eseridir.\n" +
                        "\n" +
                        "Caminin duvarlarında bulunan 19. yüzyılın ikinci yarısında ve 20. yüzyılın başlarında farklı hattatlar tarafından yazılmış 192 adet hat levhası ve duvar yazısı, hat sanatının özgün örnekleri arasında gösterilir.\n" +
                        "\n" +
                        "Caminin iç mekanında, tepesi açık bir kubbenin altında bulunan şadırvan, Ulu Cami’nin dikkat çekici özelliklerindendir.";
            }  else if (selectedMekan.equals("Koza Han")) {
                mekanAciklama= "Koza Han 15. yüzyıl sonlarında II. Bayezid tarafından mimar Abdül ula bin Pulat Şah'a İstanbul'daki eserlerine vakıf olarak Bursa'da yaptırılmış handır.\n" +
                        "\n" +
                        "Hanlar Bölgesi'nde Ulu Cami ile Orhan Camii arasında bulunur. Osmanlı devri han ve kervansaray mimarisinde -ortasındaki mescit bakımından - eski gelenekleri sürdüren ve bütünlüğünü koruyabilmiş olan bir eserdir.[1]. Anıtsal giriş kapısı ve avlusunda bulunan altı şadırvanlı köşk mescit Bursa'nın simgeleri arasında kabul edilir.\n" +
                        "\n" +
                        "Geçmişte Yeni Han, Han-ı Cedid, Han-ı Cedid-i Evvel (Pirinç Han’ın yapılmasından sonra), Han-ı Cedid-i Amire, Yeni Kervansaray, Beylik Han, Beylik Kervansaray, Simkeş Han, Sırmakeş Han gibi birçok adla anılmış olan yapı,[2] içinde ipek kozası ticareti yapıldığı için Koza Han adıyla anılır olmuştur. Koza ticareti için Bursa'ya gelen ipek tüccarları konaklama hizmeti veren handa altlı üstlü iki oda tutmuşlar; üstteki odayı ticari işlerini görmek ve konaklamak, alttaki odayı da ticaret mallarını depolamada kullanmışlardır.[2] Han, günümüzde ticarî işlevini korumaktadır.[";
            }  else if (selectedMekan.equals("Korupark Alışveriş Merkezi")) {
                mekanAciklama= "Torunlar Gayrimenkul Yatırım Ortaklığı’nın Zafer Plaza ve Antalya Deepo Outlet Center’dan sonra 8 Eylül 2007 tarihinde açılışı yapılan Bursa’nın en büyük alışveriş merkezi Korupark etkileyici bir büyüklük ve benzersiz mağaza karması ile çevre illere de hitap ediyor. \n" +
                        "\n" +
                        "Mimari projesini Tago Mimarlık’ın yaptığı Korupark Alışveriş Merkezi 165.286 metrekare toplam inşaat alanı ve 71.267 metrekare kiralanabilir alanı ile 196 seçkin ulusal ve uluslararası markaya ev sahipliği yapıyor. \n" +
                        "\n" +
                        "İki kapalı otopark, üç çarşı ve bir sinema katından oluşan Korupark Avm büyüklüğü, mimarisi, lokasyonu, aydınlatma açısından gün ışığına olanak tanıyan atriumu ve mağaza karması ile Bursa’da alışveriş alışkanlıklarını değiştiren farklı bir avm olma özelliği de gösteriyor. \n" +
                        "\n" +
                        "196 seçkin mağazada binlerce markanın ürününe ulaşılabilen Korupark Alışveriş Merkezi’ni farklı kılan özelliklerden birisi de 50’ye yakın markanın ilk defa Bursa’da Korupark’ta açılmış olması. Toplam 69 ülkede 3 binden fazla mağazası bulunan dünyaca ünlü giyim markası ZARA ve Inditex grubunun tüm alt markalarının da Korupark içerisinde yer alması alışveriş merkezini farklı kılan özelliklerden. Türkiye’de aynı çatı altında ilk kez bir araya gelen dünya markaları da Bursa’da Korupark’ta yer alıyo";

            }  else if (selectedMekan.equals("Kent Meydanı AVM")) {
                mekanAciklama= "Dünyada bazı ülkeler var ki tarihleri, tarihi eserleri ve kültürleri kadar şehirleri ve meydanlarıyla da ünlüdür. Türkiye’nin en değerli şehirlerinden Bursa’nın da en ünlü meydanıdır Kent Meydanı AVM!\n" +
                        "Küçükçalık İnşaat A.Ş, Sönmez Turizm Emlak A.Ş ve Özipek İnşaat A.Ş’den oluşan ortaklık yapısıyla faaliyete geçen proje, Avrupa standartlarında tasarlanmış, ödüllü bir mimari proje olarak doğmuştur. Ayda ortalama 1.100.000 ziyaretçiyi ağırlayan ve 104 farklı markayı bünyesinde bulunduran alışveriş merkezi, toplam 29.800m2 kiralanabilir alana sahiptir.\n" +
                        "Kent Meydanı AVM, şehrin tam merkezinde yer alması ve kolay ulaşımı sayesinde açıldığı günden bu yana her yaş grubunun buluşma noktası olmuştur. Bazen bir kahve, bazen bir sinema için tercih edilen alışveriş merkezi, 6.500 metrekarelik meydanında çok sayıda açık hava etkinliğine ev sahipliği yapmaktadır. Hayata geçirdiği konserler ve projelerle Bursa’nın kültürel merkezi olma özelliğini de pekiştirmektedir.\n" +
                        "Kent Meydanı AVM, Bursalıların kolayca ulaştığı, bütün ihtiyaçlarını hızlıca karşılayabildiği, hareketli ve canlı bir yaşam merkezidir.";
            }  else if (selectedMekan.equals("Bursa Teknik Üniversitesi")) {
                mekanAciklama= "Bursa'nın ikinci devlet üniversitesi olarak 21.07.2010 tarih ve 27648 sayılı Bakanlar Kurulu kararına göre kurulmuştur. Kurucu rektörü Prof. Dr. Ali Sürmen, 11 Aralık 2014 itibarıyla rektörü Prof. Dr. Arif Karademir'dir\n" +
                        "Üniversitede 2019-2020 akademik yılında, 4807 lisans, 1213 yüksek lisans öğrenci öğrenim görür.\n" +
                        "\n" +
                        "2020 itibarıyla üniversitede 33 profesör, 38 doçent, 116 doktor, 223 öğretim ve araştırma görevlisi, ayrıca 154 idari ve 100 hizmet personeli bulunmaktadır\n" +
                        "\n" +
                        "Üniversitede 2 enstitü, 6 fakülte, 2 yüksek okul ve 10 araştırma merkezi vardır.";
            }  else if (selectedMekan.equals("Bursa Uludağ Üniversitesi")) {
                mekanAciklama= "Aklın ve bilimin öncülük ettiği çağdaş, demokratik, özgür düşünceli ve kişisel sorumluluk duyguları gelişmiş, toplumun inanç ve değerlerine saygılı, kültürel ve tarihi değerlerini benimsemiş, uluslararası vizyon sahibi gençler yetiştirmeyi amaç edinen üniversitemize bağlı olarak, 15 Fakülte, 2 Yüksekokul, 15 Meslek Yüksekokulu, 1 Konservatuar, 4 Enstitü, 27 Uygulama ve Araştırma Merkezi ile 1 Araştırma Merkezi ve Rektörlüğe bağlı olarak kurulan 5 bölüm bulunmaktadır.\n" +
                        "\n" +
                        "1970 yılında İstanbul Üniversitesi'ne bağlı olarak kurulan Bursa Tıp Fakültesi ile 1974 yılında kurulan Bursa İktisadi ve Sosyal Bilimler Fakültesi  Üniversitenin temelini oluşturmaktadır.\n" +
                        "\n" +
                        "11 Nisan 1975 tarih ve 15205 sayılı Resmi Gazetede yayınlanan 1873 Sayılı Kanun ile Bursa’da “Bursa Üniversitesi” adı ile kurulan Üniversitemiz, 20 Temmuz 1982 tarihinde Yükseköğretim Kurumları Teşkilatı hakkında 41 sayılı Kanun Hükmünde Kararname ile \"Uludağ Üniversitesi\" adını almıştır. Ancak 18 Mayıs 2018 tarih ve 30425 Sayılı Resmi Gazete'de yayınlanarak yürürlüğe giren 7141 sayılı \"Yükseköğretim Kanunu ile Bazı Kanun ve Kanun Hükmünde Kararnamelerde Değişiklik Yapılmasına Dair Kanun\" ile üniversitemizin adı \"BURSA ULUDAĞ ÜNİVERSİTESİ\" olmuştur.";
            }  else if (selectedMekan.equals("Bursa Şehir Hastanesi")) {
                mekanAciklama= "Bursa Şehir Hastanesi, Sağlık Bakanlığı ve Rönesans Sağlık Yatırım tarafından, Kamu Özel İşbirliği modeli ile Temmuz 2019'da hizmete açılmıştır.\n" +
                        "\n" +
                        "745.000 m2 arsa ve 470.000 m2 toplam inşaat alanına kurulmuş olan, 1.355 yatak kapasiteli Bursa Şehir Hastanesi’nin; Bursa ve çevre illerine dünya standartlarında sağlık hizmeti sunması planlanmaktadır. Ortak bir çekirdek yapı etrafında konumlandırılan dört kule ve ek bina yapılarında kurulmuş olan kampüste aşağıdaki hastaneler bulunmaktadır;\n" +
                        "\n" +
                        "Genel Hastane\n" +
                        "Kalp ve Damar Hastalıkları Hastanesi\n" +
                        "Onkoloji Hastanesi\n" +
                        "Kadın Doğum ve Çocuk Hastanesi\n" +
                        "Yüksek Güvenlikli Adli Psikiyatri (YGAP) Hastanesi \n" +
                        "Fizik Tedavi ve Rehabilitasyon (FTR) Hastanesi\n" +
                        "Bursa Şehir Hastanesi ana hastane binasına yerleştirilmiş olan, dünyanın en gelişmiş teknolojisine sahip 859 sismik izolatör; olası bir deprem sırasında ve sonrasında tüm operasyonel faaliyetlerin depremden etkilenmeden sürdürülmesini mümkün kılmaktadır.\n" +
                        "\n" +
                        "Leed Gold standartlarına uygun olarak tasarlanan hastane, ‘Çevreye Duyarlı Yapı Sertifikası’ olan \"LEED Gold Sertifikası\"na sahiptir. ";
            }
            else if (selectedMekan.equals("Gemlik Devlet Hastanesi")) {
                mekanAciklama= "Gemlik Devlet Hastanesi ilk olarak Ekim 1989 tarihinde Yalova yolu üzerindeki binasında hizmetine başlamıştır. 17 Ağustos 1999 depreminde binanın 8 ana kolonunun hasar görmesi nedeniyle 21 Eylül 1999 tarihinde bina tahliye edilerek hizmeti çadırda sunmak zorunda kalmış, daha sonra kış mevsimi gelince poliklinik hizmeti olarak barakalarda devam etmiştir.Hayır sever iş adamı Sn.Muammer Ağım tarafından 10 Ekim 1988’de temeli atılan modern hastane binamız 18 Eylül 2000 tarihinde tamamlanarak hastalarımızın hizmetine sunulmuştur. Muammer Ağım Gemlik Devlet Hastanesi’nin toplam arazisi 9500 m2 olup; hastane binası insaat tekniği bakımından çelik konstrüksiyon ile yapilmış Türkiye’nin ilk hastanesidir. 5 kat yükseklikte toplam 4500 m2 kullanım alanı bulunan hastanenin taban alanıysa 768 m2 dir. \n" +
                        "\n" +
                        "2004 yili itibariyle Hastane arsamiz üzerinde Ek Hizmet Binasi yaptirilmasina karar verilmistir. 800 m2 lik bir taban alanına baslangıçta Hemodiyaliz Ünitesi ve Acil Servis olarak planlanan bu proje daha sonra poliklinikler ve idari birimlerin de yer aldığı toplam 3 katlı (Zemin ile birlikte) bir bina olarak tamamlanmıştır. 04.07.2006 tarihinde hizmet sunmaya baslamistir. Gemlik SSK hastanesi, 2006 yılından itibaren hastanemizin Sahil Binası olarak hizmet vermeye başlamıştır.\n" +
                        " 2006 Yılında ''Bebek Dostu Hastane'' unvanını alan hastanemiz anne ve bebek sağlığı, emzirmenin önemi konusunda bilgilendirici ve destekleyici faaliyetlerde bulunmaktadır.  2012 yılında Hisar mahallesinde'Toplum ve Ruh Sağlığı Merkezi' hizmete girmiştir. 2014 Eylül ayı itibariyle Hastanemiz bünyesinde MR  hizmetimiz başlamıştır.\n" +
                        "\n" +
                        "Gemlik Devlet Hastanesi olarak 26.12.2014 tarihinde temeli atılan yeni hastane binamıza 09.06.2018 tarihinde sahil binasında bulunan poliklinikler ile diş poliklinikleri, 20.07.2018 tarihinde ise manastır binasında bulunan birimlerin tamamı ile geçilerek hizmet vermeye başlanmıştır.Hastanemiz toplam 29.918 m2 arsa alanı üzerinde 6.987 m2 oturma alanı ve 35.103 m2 kapalı alana sahip A, B, C ve D olmak üzere toplam dört blok ile 260 yatak, 61 poliklinik, Acil Servis, 1.-2.-3. Basamak Yoğun Bakım Üniteleri, Hemodiyaliz Ünitesi, Palyatif Bakım Servisi ve Evde Sağlık Hizmeti ile hizmet vermekteyiz";
            }
                      //  İZMİR

            else if (selectedMekan.equals("Efes Antik Kenti")) {
                mekanAciklama= "Selçuk ilçesi sınırları içindeki antik Efes kentinin ilk kuruluşu M.Ö. 6000 yıllarına dayanıyor. Son yıllarda yapılan araştırma ve kazılarda Efes, çevresindeki höyükler ve kalenin bulunduğu Ayasuluk Tepesi'nde Tunç Çağları ve Hittitler'e ait yerleşimler saptanmıştır. Hititler döneminde kentin adı Apasas'tır. M.Ö. 1050 yıllarında Yunanistan'dan gelen göçmenlerin de yaşamaya başladığı liman kenti Efes, M.Ö. 560 yılında Artemis Tapınağı çevresine taşınmıştır. Bugün gezilen Efes ise, Büyük İskender'in generallerinden Lysimakhos tarafından M.Ö. 300 yıllarında kuruldu. Helenistik ve Roma dönemlerinde en görkemli zamanlarını yaşayan Efes, Asya eyaletinin başkenti ve en büyük liman kenti olarak 200.000 kişilik nüfusa sahipti. Efes, Bizans dönemi tekrar yer değiştirmiş ve ilk kez kurulduğu Selçuk'taki Ayasuluk Tepesi'ne gelmiştir.";
            }  else if (selectedMekan.equals("Kemeraltı Çarşısı")) {
                mekanAciklama= "1650–1670 yıllarından itibaren deniz kıyısının doldurulması ve yeni yerleşim alanları ile ticarethanelerin açılması ile oluşturulmuştur. 1592'de inşa edilmiş Hisar Camii'nin bulunduğu mevkiden başlatılmış bu yayılmanın çizgisini, başka bir şekilde eski deniz kıyısı hattını günümüzdeki Anafartalar Caddesi oluşturur. İnşa edilen günümüze ulaşmış en önemli hanlardan biri 1744 yılında Hacı Beşir Ağa tarafından yaptırılan Kızlarağası Hanı'dır. Bunun dışında semtte çok sayıda han inşa edilmiştir. Kemeraltı Çarşısı ilk yıllarında üzeri tonoz ve kiremit örtülü, sokakları kapsayan bir kapalı çarşı görünümünde idi. Çarşı 19. yüzyılın sonlarına kadar bu özelliğini korumuştur. Bugün üzeri açık olan ara sokakların bir bölümünün de üzeri beşik tonozla örtülü idi.";
            }  else if (selectedMekan.equals("Hilltown Karşıyaka AVM")) {
                mekanAciklama= "Optimum, Piazza, Kozzy, Maltepe Park ve Hilltown markalı 12 alışveriş merkezi ile 7 ilde hizmet veren Rönesans Gayrimenkul’ün İzmir Karşıyaka’da inşa edilen yeni projesi Hilltown Karşıyaka Alışveriş Merkezi, yeni nesil sürdürülebilir alışveriş merkezi kategorisinde yer almaktadır. Konsept mimarisi T-Concept imzası taşıyan proje, sahip olduğu mimarisi, kolay ulaşılabilir lokasyonu, seçkin markaları, alışveriş caddesinde konumlanan cafe, restoran ve eğlence alanlarıyla misafirlerine yeni bir yaşam deneyimi vaadediyor.\n" +
                        "\n" +
                        "Adını mimari özellikler ile birlikte küçük bir şehri andırması sonucunda alan Hilltown Karşıyaka, ulusal ve uluslararası 44'ü kafe-restoran olmak üzere 196 mağazası, İzmir'de ilk kez Hilltown Karşıyaka'da yer alan \"Starium\" salonu, Gold Class ve Home Class salonlarını da içeren toplam 7 adet sinema salonu, 2.750 araçlık kapalı otoparkı, açık teraslı kafe ve restoranları, farklı yaş grupları için toplamda 1.500 m²’lik çocuk oyun parkı, 2.000 m²’lik etkinlik alanı, rengarenk peyzaj mimarisi ile tamamlanmış meydanlarıyla ziyaretçilerine sosyal ve kültürel bir yaşam alanı sunuyor.\n" +
                        "Engelli ve aile tuvaletleri, bebek bakım odaları, emanet dolabı, vestiyer, mescit, vale ve ücretsiz wifi hizmetine kadar tüm ihtiyaçların düşünüldüğü Hilltown Karşıyaka Alışveriş Merkezi, dünyaca ünlü markalarıyla dikkat çekerken; her yaşa ve damak tadına uygun dünya mutfağının bir arada olduğu food court ve restoran alanı Avlu’nun yanı sıra, evcil hayvan dostu konseptiyle de ziyaretçilerin beklentilerine cevap veriyorTürkiye’nin 3. büyük şehri İzmir’in, Karşıyaka ilçesindeki Mavişehir semtinde ilçenin kuzeyinde konumlanmış olan Hilltown Karşıyaka Alışveriş Merkezi, İzban Mavişehir istasyonuna 500 Metre, Adnan Menderes Havalimanı’na 34 km uzaklıkta yer almaktadır.\n" +
                        "\n" +
                        "2021 ICSC Design and Development Awards’da kazandığı Altın Ödül ve Sürdürülebilirlikte Takdir Ödülleri ile Dünyanın En İyi Alışveriş Merkezi olduğunu kanıtlayan Hilltown Karşıyaka; yeni yıl ruhunu büyüterek festival ruhuna dönüştürdüğü Christmas Bazaar projesi ile de 2023 ICSC MAXI Gümüş Ödüle layık görülmüştür.";

            }  else if (selectedMekan.equals("İzmir Optimum AVM")) {
                mekanAciklama= "30 Mart 2012’de outlet konseptinde kapılarını ziyaretçilerine açan ve İzmir’in en popüler alışveriş merkezi olan İzmir Optimum, 31 Mart 2017 tarihinde ‘Büyüme ve Dönüşüm’ projesi sonunda outlet konseptinden çıkarak regular AVM konseptinde, İzmir’in ve Ege Bölgesinin en büyük Alışveriş Merkezi olarak hizmet vermeye devam etmektedir.\n" +
                        "\n" +
                        "235.000 m2 lik bir alana kurulu olan İzmir Optimum; 86.000 m2 kiralanabilir alanında 252 mağazası, 3000 araçlık kapalı otoparkı, sinema salonları, bowling, buz paten pisti, açık teraslı cafe ve restoranları, farklı yaş grupları için toplamda 3.000 m2’lik ücretsiz 2 çocuk oyun parkı ile ziyaretçilerine sosyal ve kültürel bir yaşam alanı sunmaktadır.\n" +
                        "Engelli ve çocuk tuvaletlerinden bebek bakım odalarına, mescitten vale hizmetine tüm ihtiyaçların düşünüldüğü İzmir Optimum zengin marka karmasıyla dikkat çekerken, her yaşa ve damak tadına uygun lezzetlerin bir arada olduğu 1400 kişilik food court katıyla da ziyaretçilerin beklentilerine cevap vermektedir.\n" +
                        "Ödüller:\n" +
                        "ICSC SOLAL MARKETING 2018 Altın Ödül:  Elele Kafe “Avrupa’nın En iyi Sosyal Sorumluluk Projesi”\n" +
                        "ICSC 2018 Yenileme ve Genişleme(Büyük AVM) kategorisinde Avrupa’nın en iyi Alışveriş Merkezi Ödülü\n" +
                        "MarCom 2018 Platinum Ödül: Film Galaları “Yılın Pazarlama Kampanyası kategorisi”\n" +
                        "The Stevie Awards 2018 : İki Farklı Kategoride Bronz Ödül: Film Galaları, “Yılın Pazarlama Kampanyası ve Sanat ve Eğlence dalında Yılın Halkla İlişkiler Etkinliği”\n" +
                        "İki Farklı Kategoride Gümüş ve Bronz Ödül: Elele Kafe, “En İyi Tüketici Etkinliği ve Avrupa'da Yılın Kurumsal Sosyal Sorumluluk Programları”ır.";
            }  else if (selectedMekan.equals("Ege Üniversitesi")) {
                mekanAciklama= "Ege Üniversitesi, 20 Mayıs 1955 tarihinde yayınlanan 6595 sayılı kanunla 9 Mart 1956 tarihinde, İzmir'de Ege Bölgesi’nin ilk, Türkiye'nin 5. üniversitesi olarak eğitim-öğretim hayatına başlayan devlet üniversitesi.Türkiye'nin en çok tercih edilen üniversitelerinin başında gelen Ege Üniversitesi, Türkiye’de ve dünyada birçok ilklere imza atmıştır.\n" +
                        "\n" +
                        "Ödemiş, Bayındır, Bergama, Tire ve Çeşme ilçelerinde yüksekokul ve meslek yüksekokulları bulunan Ege Üniversitesi, Bornova’da 3.450 dekarlık bir arazi üzerine kurulmuştur. En son teknoloji ile donatılmış modern bir kütüphanesi, sosyal tesisleri, açık ve kapalı yüzme havuzları, kapalı spor salonları, spor tesisleri, toplum merkezi, alışveriş merkezi, sergi alanları ve Öğrenci Köyü ile 70.000 kişilik bir kampüs kenttir.\n" +
                        "\n" +
                        "Kampüs içinde kongre, seminer, kültür ve sanat etkinlikleri için hizmet veren Prof.Dr. Yusuf Vardar – MÖTBE Kültür Merkezi ve kampüs dışında, İzmir kent merkezinde (Konak) Atatürk Kültür Merkezi, Menemen’de Deneme İstasyonu ve Üretme Çiftliği, Kurudağ’da Rasathanesi, Urla’da ve Tuzla’da su ürünleri tesisleri, Özdere’de Yaz Kampı ve Çeşme’de eğitim ve dinlenme tesisleri bulunmaktadır.";
            }  else if (selectedMekan.equals("Dokuz Eylül Üniversitesi")) {
                mekanAciklama= "Dokuz Eylül Üniversitesi (DEÜ), İzmir'de bulunan bir devlet üniversitesi. 20 Temmuz 1982 tarihinde kuruldu. Üniversitede 10 enstitü, 18 fakülte, 2 yüksekokul, 1 konservatuvar, 6 meslek yüksekokulu, 2'si uygulama ve araştırma hastanesi olmak üzere 49 uygulama ve araştırma merkezi vardır. Üniversite 2023 yılı “Sürdürülebilirlik” listesinde Türkiye'deki devlet üniversiteleri sıralamasında 4'üncü olurken; genel sıralamada dünyada 451-500 aralığında yer aldı.\n" +
                        "\n" +
                        "Dokuz Eylül Üniversitesi’nde 2022-2023 akademik yılında toplam 68 bine yakın öğrenci eğitim görmektedir. Bunlar arasında, 103 ülkeden gelen 4 bin 600’den fazla uluslararası öğrenci bulunmaktadır. Üniversite bünyesinde 3 binin üzerinde akademik personel ve 5 bine yakın idari personel görev yapmaktadır.";
            }  else if (selectedMekan.equals(" Alsancak Nevvar Salih İşgören Devlet Hastanesi")) {
                mekanAciklama= "Bursa Şehir Hastanesi, Sağlık Bakanlığı ve Rönesans Sağlık Yatırım tarafından, Kamu Özel İşbirliği modeli ile Temmuz 2019'da hizmete açılmıştır.\n" +
                        "\n" +
                        "745.000 m2 arsa ve 470.000 m2 toplam inşaat alanına kurulmuş olan, 1.355 yatak kapasiteli Bursa Şehir Hastanesi’nin; Bursa ve çevre illerine dünya standartlarında sağlık hizmeti sunması planlanmaktadır. Ortak bir çekirdek yapı etrafında konumlandırılan dört kule ve ek bina yapılarında kurulmuş olan kampüste aşağıdaki hastaneler bulunmaktadır;\n" +
                        "\n" +
                        "Genel Hastane\n" +
                        "Kalp ve Damar Hastalıkları Hastanesi\n" +
                        "Onkoloji Hastanesi\n" +
                        "Kadın Doğum ve Çocuk Hastanesi\n" +
                        "Yüksek Güvenlikli Adli Psikiyatri (YGAP) Hastanesi \n" +
                        "Fizik Tedavi ve Rehabilitasyon (FTR) Hastanesi\n" +
                        "Bursa Şehir Hastanesi ana hastane binasına yerleştirilmiş olan, dünyanın en gelişmiş teknolojisine sahip 859 sismik izolatör; olası bir deprem sırasında ve sonrasında tüm operasyonel faaliyetlerin depremden etkilenmeden sürdürülmesini mümkün kılmaktadır.\n" +
                        "\n" +
                        "Leed Gold standartlarına uygun olarak tasarlanan hastane, ‘Çevreye Duyarlı Yapı Sertifikası’ olan \"LEED Gold Sertifikası\"na sahiptir. ";
            }
            else if (selectedMekan.equals("Dr. Behçet Uz Çocuk Hastalıkları Eğitim ve Araştırma Hastanesi")) {
                mekanAciklama= "Dr. Behçet Uz Çocuk Hastalıkları Eğitim ve Araştırma Hastanesi’ nin temeli  kurucusu olan Dr.  Behçet Uz tarafından 23-Nisan-1938’de atılmıştır. Dr. Uz  Maddi imkansızlıklara rağmen İzmir  belediye başkanı olduğu dönemde  Valilik, Belediye ve halktan yardım toplayarak 900 bin TL olan  keşif  bedelli inşaata 30 bin TL ile ise başlamıştır.\n" +
                        "\n" +
                        "Doktor Uz  Sağlık Bakanlığı  döneminde, İzmir Belediye meclisini ikna ederek 21-10-1946’da hastaneyi Sağlık Bakanlığına  hibe ettirmiş, Bakanlığa binanın bazı noksanlarını tamamlattırarak, 2-4-1947’de dönemin başbakanı Recep Peker’le İzmir’ e  gelerek  hastaneyi hizmete açmıştır.  Kızılay’ ın 1954’ te yaptırdığı Doğum Pavyonu, İzmir Hastanelerine Yardım Derneği’ nin çabaları, çeşitli kuruluşlar ve halkın bağışları ile 1962’de İntaniye Pavyonu, 1968’de Ortopedi ve Travmatoloji Pavyonu, 1975’de ana binanın üstüne kat ilavesi yapılmıştır. Buna paralel olarak, Sağlık Bakanlığı tarafından kadrosu genişletilmiştir.\n" +
                        "Hizmete 150 yatakla başlayan hastane; çeşitli kişi kurum ve kuruluşların katkılarıyla  1968’de (21 yılda) 550 yatak kapasitesine ulaşmıştır. Halen 350 yatakla hizmet vermeye devam etmektedir.\n" +
                        "\n" +
                        "Yarım asrı aşkın Ege Bölgesi ve ülkemizin dört bir yanından gelen hastalara Çocuk sağlığı hizmetlerini her branşta sunan hastanemiz aynı zamanda Çocuk Sağlığı ve Hastalıkları ile Çocuk Cerrahi ihtisası vererek yüzlerce uzman doktor yetiştirmiş ve yetiştirmeye devam eden bir eğitim hastanesidir.";
            }








            return mekanAciklama;
        }

        return "";
    }


    private String getMekanAdressForPosition(int position) {
        if (itemList != null && position >= 0 && position < itemList.size()) {
            String selectedMekan = itemList.get(position);


            String mekanAdress = "";


            //KONYA

            if (selectedMekan.equals("Mevlana Müzesi")) {
                mekanAdress = "Aziziye Mah, Mevlana Cd. No:1, 42030 Karatay/Konya";
            }
             else if (selectedMekan.equals("Karatay Medresesi")) {
                mekanAdress= " Ferhuniye, 42040 Selçuklu/Konya";
            }  else if (selectedMekan.equals("KentPlaza AVM")) {
                mekanAdress= "Bedir, Ataseven Cd. No:2, 42100 Selçuklu/Konya";
            }  else if (selectedMekan.equals("KuleSite AVM")) {
                mekanAdress= "Musalla Bağları, 42060 Selçuklu/Konya";
            }  else if (selectedMekan.equals("Selçuk Üniversitesi")) {
                mekanAdress= "Ardıçlı, İsmetpaşa Cad, 42250 Selçuklu/Konya";
            }  else if (selectedMekan.equals("KTO Karatay Üniversitesi")) {
                mekanAdress= "Akabe, Alaaddin Kap Cd. No:130, 42020 Karatay/Konya";
            }  else if (selectedMekan.equals("Selçuk Üniversitesi Tıp Fakültesi")) {
                mekanAdress= "Ardıçlı, Akademi, Celal Bayar Cd. No:313, 42250 Selçuklu/Konya";
            }  else if (selectedMekan.equals("Konya Numune Hastanesi")) {
                mekanAdress= " Ferhuniye, Hastane Cd., 42060 Selçuklu/Konya";
            }

             //TEKİRDAĞ

            else if (selectedMekan.equals("Süleymaniye Cami")) {
                mekanAdress= "Reşadiye, Salih Omurtak Cd. No:137, 59850 Çorlu/Tekirdağ";
            }  else if (selectedMekan.equals("Çorlu Kalesi")) {
                mekanAdress= " Hıdırağa, Salhane Sk. No:37, 59850 Çorlu/Tekirdağ";
            }  else if (selectedMekan.equals("Tekira Alışveriş Merkezi")) {
                mekanAdress= "Aydoğdu, Hükümet Cd. No:186, 59100 Merkez/Tekirdağ";
            }  else if (selectedMekan.equals("Çerkezköy Center")) {
                mekanAdress= "Gazi Mustafa Kemalpaşa, Kadife Sk No:1, 59500 Çerkezköy/Tekirdağ";
            }  else if (selectedMekan.equals("Tekirdağ Namık Kemal Üniversitesi")) {
                mekanAdress= " Namık Kemal Kampüs Cad No:1, 59030 Süleymanpaşa/Tekirdağ";
            }  else if (selectedMekan.equals("Tekirdağ Devlet Hastanesi")) {
                mekanAdress= "Eskicami-ortacami mah,Muratlı cad.Hastane sok. 59100 Süleymanpaşa/Tekirdağ";
            }  else if (selectedMekan.equals("Çerkezköy Devlet Hastanesi")) {
                mekanAdress= "Fatih, Fatih Mh Şehit Teğmen Akın Akın Cd, Üzümlü Sk. No:1, 59500 Çerkezköy/Tekirdağ";
            }

            //SİVAS

            else if (selectedMekan.equals("Çifte Minareli Medrese")) {
                mekanAdress= " Eski Kale Mh, Sivas TR, Çifteminare Sk. No:1, 58000";
            }  else if (selectedMekan.equals("Gök Medrese")) {
                mekanAdress= "Gökmedrese, Gökmedrese Cad., 58070 Merkez/Sivas Merkez/Sivas";
            }  else if (selectedMekan.equals("İvapark Avm Sivas")) {
                mekanAdress= "Gültepe, Farabi Cd. No:22, 58080 Okullar Bölgesi/Sivas Merkez/Sivas";
            }  else if (selectedMekan.equals("Sivas Cumhuriyet Üniversitesi")) {
                mekanAdress= " Sivas Cumhuriyet Üniversitesi Hukuk Fakültesi 58140 Merkez Merkez, Sivas";
            }  else if (selectedMekan.equals("Sivas Bilim ve Teknoloji Üniversitesi")) {
                mekanAdress= "Gültepe, Mecnun Otyakmaz Cd No:1, 58000 Sivas Merkez/Sivas";
            }  else if (selectedMekan.equals("Sivas Devlet Hastanesi")) {
                mekanAdress= " Örtülüpınar Mah. İnönü Bulvarı No: 41 Merkez Sivas";
            }  else if (selectedMekan.equals("Divriği Devlet Hastanesi")) {
                mekanAdress= " 58300 Günbahçe/Divriği/Sivas";
            }


            return mekanAdress;
        }

        return "";
    }
}
