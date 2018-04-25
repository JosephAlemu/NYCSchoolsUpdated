package a20180417_ja_nyschools.com.a20180417_ja_nyschools;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import a20180417_ja_nyschools.com.a20180417_ja_nyschools.Api.Api;
import a20180417_ja_nyschools.com.a20180417_ja_nyschools.model.Detail;
import a20180417_ja_nyschools.com.a20180417_ja_nyschools.model.School;
import a20180417_ja_nyschools.com.a20180417_ja_nyschools.model.SchoolType;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;

    private RecyclerAdapter adapter;
    List<School> schools;
    ArrayList<Detail> details;
    public String[] cityName;
    ArrayList<SchoolType> schoolTypes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        schoolTypes = new ArrayList<>();

        LoadDataMethod();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);


        // setData();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        adapter = new RecyclerAdapter(this, schoolTypes);
        recyclerView.setAdapter(adapter);


    }


    private void LoadDataMethod() {


        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        final String BASE_URL = "https://data.cityofnewyork.us/";
        //https://data.cityofnewyork.us/resource/97mf-9njv.json

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        Api api = retrofit.create(Api.class);

        api.getSchool().enqueue(new Callback<List<School>>() {
            @Override
            public void onResponse(Call<List<School>> call, Response<List<School>> response) {
                schools = response.body();
                Log.w("Hey", schools.toString());

                method(schools);
            }


            @Override
            public void onFailure(Call<List<School>> call, Throwable t) {

            }
        });
    }

    private void method(List<School> schools) {
        String cityName[] = method();


        details = new ArrayList<>();

        for (int j = 0; j < cityName.length; j++) {

            String name = cityName[j];

            for (int i = 0; i < schools.size(); i++) {
                String nametwo = schools.get(i).getCity();
                if (name.equalsIgnoreCase(nametwo)) {
                    String schoolName = schools.get(i).getSchoolName();
                    String zip = schools.get(i).getZip();

                    details.add(new Detail(schoolName, zip));
                    Log.w("-", schools.get(i).getCity());
                }

            }

            schoolTypes.add(new SchoolType(name, details));
            details = null;
            details = new ArrayList<>();
        }

        adapter.notifyDataSetChanged();
    }


    private String[] method() {


        String cityName[] = {"Astoria", "Bayside", "Bellerose", "Bronx", "Brooklyn", "Cambria Heights",
                "Corona", "Elmhurst", "Far Rockaway", "Flushing", "Forest Hills", "Fresh Meadows",
                "Hollis", "Jamaica", "Long Island City", "Manhattan", "Oakland Gardens", "Ozone Park",
                "Queens Village", "Richmond Hill", "Ridgewood", "Rockaway Park", "Saint Albans",
                "South Ozone Park", "South Richmond Hill", "Springfield Gardens", "Staten Island"};
        return cityName;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        adapter.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        adapter.onRestoreInstanceState(savedInstanceState);
    }


}
