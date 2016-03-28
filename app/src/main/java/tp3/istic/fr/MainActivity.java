package tp3.istic.fr;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity implements GeolocalisationListener {

   int index;
    DetailFragment detailFragment;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        if(savedInstanceState == null) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ListFragment listFragment = new ListFragment();
            ft.add(R.id.displayList, listFragment, "List_Fragment");
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }

        if(findViewById(R.id.displayDetail) != null){

            getFragmentManager().popBackStack();

            detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.displayDetail);
            if(detailFragment == null){
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                detailFragment = new DetailFragment();
                ft.replace(R.id.displayDetail, detailFragment, "Detail_Fragment1");
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
        }
    }


    @Override
    public void onURLSelected(int index){
        this.index = index;
        View view = findViewById(R.id.displayDetail);

        if(view != null){

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            DetailFragment detailFragment = new DetailFragment();
            detailFragment.setIndex(index);

            fragmentTransaction.replace(R.id.displayDetail, detailFragment);
            fragmentTransaction.commit();

        } else {
            DetailFragment detailFragment = new DetailFragment();
            detailFragment.setIndex(index);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.displayList, detailFragment, "Detail_Fragment2");
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);
            ft.commit();
        }
    }

    public void localiser(View view){

        View view1 = findViewById(R.id.displayDetail);
        if(view1!= null){

            MapFragment map = new MapFragment();
            map.setIndex(index);

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.displayDetail, map);
            fragmentTransaction.commit();
        }else {
            Intent intent = new Intent(this, MapActivity.class);
            intent.putExtra("index", index);
            startActivity(intent);
        }
    }
}
