package yu.exercise.com.mymidtermexam;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends ListActivity {
    private static String url = "joseniandroid.herokuapp.com";
//
       private static final String TAG_ID = "_id";
    private static final String TAG_TITLE = "title";
//    private static final String TAG_GENRE = "genre";
//    private static final String TAG_AUTHOR = "author";
//    private static final String TAG_READ = "isRead";

    private ListView mList;
    JSONArray books = null;
    ArrayList<HashMap<String, String>> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mList = (ListView) findViewById(R.id.list_item);

        bookList = new ArrayList <HashMap<String, String>>();
        ListView lv = getListView();

        new GetData().execute();
    }

    public class GetData extends AsyncTask<Void, Void, Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {



            HttpUtils http = new HttpUtils();

            String jsonStr = http.getResponse(url, HttpUtils.GET);

            if(jsonStr != null){

                try{
                    JSONArray jsonObject = new JSONArray(jsonStr);

                    for (int i = 0; i < jsonObject.length(); i++){
                        JSONObject b = jsonObject.getJSONObject(i);

                        String name = b.getString(TAG_TITLE);


                    }
                }
                catch (JSONException e){
                    e.printStackTrace();
                }

            }
            else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }
            return null;




        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}
