public class VolleyCustomArrayRequest extends Request<JSONArray> {

    //define the variables
    private Response.Listener<JSONArray> listener;
    private Map<String, String> params;

    //custructor
    public VolleyCustomArrayRequest(String url, Map<String, String> params,
                                    Response.Listener<JSONArray> reponseListener, Response.ErrorListener errorListener) {
        super(Method.GET, url, errorListener);
        this.listener = reponseListener;
        this.params = params;
    }

    //custructor
    public VolleyCustomArrayRequest(int method, String url,
                                    Map<String, String> params, Response.Listener<JSONArray> reponseListener,
                                    Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.listener = reponseListener;
        this.params = params;
    }

    @Override
    protected Map<String, String> getParams()
            throws com.android.volley.AuthFailureError {
        return params;
    }

    ;

    @Override
    protected void deliverResponse(JSONArray response) {
        listener.onResponse(response);
    }

    @Override
    protected Response<JSONArray> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return Response.success(new JSONArray(jsonString),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JSONException je) {
            return Response.error(new ParseError(je));
        }
    }
}

