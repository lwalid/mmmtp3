package tp3.istic.fr;

import java.util.ArrayList;
import java.util.List;


public class Model {

    List<String> places;
    List<String> urlList;
    List<Double> latitude;
    List<Double> longitude;
    public Model(){
        places = new ArrayList<String>();
        urlList = new ArrayList<String>();
        latitude  = new ArrayList<Double>();
        longitude = new ArrayList<Double>();


        urlList.add("http://www.technoresto.org/vdf/alsace/index.html");
        urlList.add("http://www.technoresto.org/vdf/beaujolais/index.html");
        urlList.add("http://www.technoresto.org/vdf/jura/index.html");
        urlList.add("http://www.technoresto.org/vdf/champagne/index.html");
        urlList.add("http://technoresto.org/vdf/savoie/index.html");
        urlList.add("http://technoresto.org/vdf/languedoc/index.html");
        urlList.add("http://technoresto.org/vdf/bordelais/index.html");
        urlList.add("http://technoresto.org/vdf/cotes_du_rhone/index.html");
        urlList.add("http://technoresto.org/vdf/provence/index.html");
        urlList.add("http://technoresto.org/vdf/val_de_loire/index.html");
        urlList.add("http://technoresto.org/vdf/sud-ouest/index.html");
        urlList.add( "http://technoresto.org/vdf/corse/index.html");
        urlList.add("http://technoresto.org/vdf/bourgogne/index.html");


        places.add("L'Alsace");
        places.add("Le Beaujolais");
        places.add("Le Jura");
        places.add("Le Champagne");
        places.add("La Savoie");

        places.add("Le Languedoc-Roussillon");
        places.add("Le Bordelais");
        places.add("La vallée du Rhône");
        places.add("La Provence");
        places.add("Le Val de Loire");

        places.add("Le Sud-Ouest");
        places.add("La Corse");
        places.add("La Bourgogne");



        latitude.add(48.2454135);
        latitude.add(46.083347);
        latitude.add(44.9248833);
        latitude.add(49.5711821);
        latitude.add(45.4946988);

        latitude.add(46.083347);
        latitude.add(44.9248833);
        latitude.add(49.5711821);
        latitude.add(48.2454135);
        latitude.add(47.3807068);

        latitude.add(43.6363165);
        latitude.add(42.1771385);
        latitude.add(47.0238172);

        longitude.add(6.4133866);
        longitude.add(4.6578908);
        longitude.add(-0.1771782);
        longitude.add(3.5427102);
        longitude.add(5.8419067);
        longitude.add(1.0179663);

        longitude.add(4.6578908);
        longitude.add(-0.1771782);
        longitude.add(3.5427102);
        longitude.add(0.2833609);

        longitude.add(6.4133866);
        longitude.add(7.9260008);
        longitude.add(4.8373574);




    }

    public List<String> getUrlList() {
        return urlList;
    }

    public List<String> getPlaces() {
        return places;
    }

    public List<Double> getLatitude() {
        return latitude;
    }

    public List<Double> getLongitude() {
        return longitude;
    }
}
