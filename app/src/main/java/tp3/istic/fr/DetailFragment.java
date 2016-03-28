package tp3.istic.fr;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DetailFragment extends Fragment {

    private View mView;
    private WebView webView;
    private int index;
    Model model;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model= new Model();
        if(savedInstanceState != null){
            int i = savedInstanceState.getInt("index");
            this.index = i;
            WebView view = (WebView) mView.findViewById(R.id.webView);
            view.loadUrl(model.getUrlList().get(i));
        }

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            index = savedInstanceState.getInt("index");
        }
            WebView myWebView = (WebView) getView().findViewById(R.id.webView);
            myWebView.getSettings().setJavaScriptEnabled(true);
            myWebView.setWebViewClient(new MyWebViewClient());
            myWebView.loadUrl(model.getUrlList().get(index));


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle){
        mView = inflater.inflate(R.layout.detail_view, container, false);
        webView = (WebView) mView.findViewById(R.id.webView);
        webView.loadUrl(model.getUrlList().get(index));
        return mView;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("index", index);
    }
}
