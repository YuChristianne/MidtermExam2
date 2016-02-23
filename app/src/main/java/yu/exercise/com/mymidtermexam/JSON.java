package yu.exercise.com.mymidtermexam;

import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by User on 2/23/2016.
 */
public class JSON extends AppCompatActivity {

    private TextView mBook;
    private static final String TAG_TITLE = "title";
    private static final String TAG_ID = "_id";
    public static final String BASE_URL = "http://172.17.3.51:5856/api/books";
    public static final int SUCCESS_CODE = 200;

    public final static int GET = 1;

    public static MainActivity getBook(Uri uri, @NonNull String requestMethod) {
        String json = HttpUtils.getResponse(uri, requestMethod);

        if (TextUtils.isEmpty(json)) {
            return null;
        }

        final String title;

        try {
            JSONObject jsonObject = new JSONObject(json);

            int statusCode = jsonObject.getInt(TAG_ID);

            if (statusCode == SUCCESS_CODE) {
                title = jsonObject.getString(TAG_TITLE);
                return null;
            } else {
                return null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }
}

//
//    public static JSON newInstance(){
//        return new JSON();
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        mBook = (TextView) findViewById(R.id.txtBook);
//
//
//
