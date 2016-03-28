package tp3.istic.fr;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class ListFragment extends Fragment {

    GeolocalisationListener listener;

    Model model;

    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listView = (ListView) getView().findViewById(R.id.listofURLs);
        model = new Model();

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),R.layout.format_list, model.getPlaces());

        listView.setAdapter(dataAdapter);
        listView.setTextFilterEnabled(true);
        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                listener.onURLSelected(position);
            }
        });

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (container == null) {
            return null;
        }
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        return view;
    }

   @Override
   public void onAttach(Activity activity) {
       super.onAttach(activity);
        try {
           listener = (GeolocalisationListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " no implementation of GeolocalisationListener");
        }
    }
}
