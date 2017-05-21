public class TabFragment1 extends Fragment {

    BarChart barChart;
     private static final String  abc = "url";

StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {

                        @Override
                        public void onResponse(String response) {
							
							  try {
                                JSONArray jsonArray = new JSONArray(response);
                              

                                ArrayList<BarEntry> entries = new ArrayList<>();
                                ArrayList<String> labels = new ArrayList<String>();
                                for (int i = 0; i < jsonArray.length(); i++) {

                                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
									String value = jsonObject1.getString("get_data");
                         
                                    entries.add(new BarEntry(Float.parseFloat(get_data), i));
                                    Calendar calendar = Calendar.getInstance();
                                    calendar.setTime(result);


                                    String[] days = new String[]{"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};

                                    String day = days[calendar.get(Calendar.DAY_OF_WEEK)];

                                    labels.add(day);

                                  
                                }
                                showData(entries, labels);
                            } catch (Exception e) {
                            }
                           
                        }

                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            error.printStackTrace();
                        }
                    }) {

                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    return map;
                }
            };
            stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                    7000,//wait 7 seconds
                    2,// ,//DefaultRetryPolicy.DEFAULT_MAX_RETRIES, this is 1 //retry for two times
                    1));//DefaultRetryPolicy.DEFAULT_BACKOFF_MULT 1

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }
		
		public void showData(ArrayList<BarEntry> entries1, ArrayList<String> labels1) {

        ArrayList<BarEntry> entries = new ArrayList<>();


        BarDataSet bardataset = new BarDataSet(entries1, "Cells");


        ArrayList<String> labels = new ArrayList<String>();

        BarData data = new BarData(labels1, bardataset);
        barChart.setData(data); // set the data and list of lables into chart

        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        barChart.animateY(0);

    }
}	
