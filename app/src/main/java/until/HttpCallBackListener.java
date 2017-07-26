package until;

/**
 * Created by sandwind on 2017/7/26.
 */


public interface HttpCallBackListener {

    void onFinish(String response);

    void onError(Exception e);
}
