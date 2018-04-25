package a20180417_ja_nyschools.com.a20180417_ja_nyschools.Api;
import a20180417_ja_nyschools.com.a20180417_ja_nyschools.model.School;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by joe on 01.08.17.
 */

public interface Api {

    @GET("/resource/97mf-9njv.json")
    Call<List<School>> getSchool();

}
