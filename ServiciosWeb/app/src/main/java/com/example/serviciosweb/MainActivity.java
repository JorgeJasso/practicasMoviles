package com.example.serviciosweb;

        import android.content.Context;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.android.volley.Request;
        import com.android.volley.RequestQueue;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.StringRequest;
        import com.android.volley.toolbox.Volley;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.util.HashMap;
        import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private RequestQueue requestQueue;
    private final String BASEURL = "http://10.54.1.246:8000/api/Usuario/";
    private EditText id, usuario, clave, nombre, apellidoP,apellidoM;
    private Button btn_crear, btn_seleccionar, btn_actualizar, btn_eliminar;
    private Context ctx;
    private StringRequest strq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctx = this;
        requestQueue = Volley.newRequestQueue(ctx);

        id = (EditText) findViewById(R.id.id);
        usuario = (EditText) findViewById(R.id.usuario);
        clave = (EditText) findViewById(R.id.clave);
        nombre = (EditText) findViewById(R.id.nombre);
        apellidoP = (EditText) findViewById(R.id.apellidoP);
        apellidoM = (EditText) findViewById(R.id.apellidoM);

        btn_crear = (Button) findViewById(R.id.btn_crear);
        btn_seleccionar = (Button) findViewById(R.id.btn_seleccionar);
        btn_actualizar = (Button) findViewById(R.id.btn_actualizar);
        btn_eliminar = (Button) findViewById(R.id.btn_eliminar);

        btn_crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crear();
            }
        });
        btn_actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actualizar();
            }
        });
        btn_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminar();
            }
        });
        btn_seleccionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show();
            }
        });
    }

    private void crear() {
        strq = new StringRequest(Request.Method.POST, BASEURL+"insertar",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("rta_servidor", response);
                        Toast.makeText(ctx, response, Toast.LENGTH_LONG).show();
                    }
                },  new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error_servidor", error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams()  {
                Map<String, String> parametros = new HashMap<>();
                parametros.put("id", id.getText().toString());
                parametros.put("usuario", usuario.getText().toString());
                parametros.put("clave", clave.getText().toString());
                parametros.put("nombre", nombre.getText().toString());
                parametros.put("apellidoP", apellidoP.getText().toString());
                parametros.put("apellidoM", apellidoM.getText().toString());
                return parametros;
            }
        };
        requestQueue.add(strq);
    }

    private void actualizar() {
        strq = new StringRequest(Request.Method.POST, BASEURL+"actualizar/"+id.getText().toString(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("rta_servidor", response);
                        Toast.makeText(ctx, response, Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error_servidor", error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams()  {
                Map<String, String> parametros = new HashMap<>();
                parametros.put("id", id.getText().toString());
                parametros.put("usuario", usuario.getText().toString());
                parametros.put("clave", clave.getText().toString());
                parametros.put("nombre", nombre.getText().toString());
                parametros.put("apellidoP", apellidoP.getText().toString());
                parametros.put("apellidoM", apellidoM.getText().toString());
                return parametros;
            }
        };
        requestQueue.add(strq);
    }

    private void eliminar() {
        strq = new StringRequest(Request.Method.DELETE, BASEURL+"eliminar/"+id.getText().toString(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("rta_servidor", response);
                        Toast.makeText(ctx, response, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error_servidor", error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams()  {
                Map<String, String> parametros = new HashMap<>();
                parametros.put("id", id.getText().toString());
                parametros.put("usuario", usuario.getText().toString());
                parametros.put("clave", clave.getText().toString());
                parametros.put("nombre", nombre.getText().toString());
                parametros.put("apellidoP", apellidoP.getText().toString());
                parametros.put("apellidoM", apellidoM.getText().toString());
                return parametros;
            }
        };
        requestQueue.add(strq);
    }

    private void show() {
        strq = new StringRequest(Request.Method.GET, BASEURL+id.getText().toString(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("rta_servidor", response);
                        Toast.makeText(ctx, response, Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error_servidor", error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams()  {
                Map<String, String> parametros = new HashMap<>();
                parametros.put("id", id.getText().toString());
                parametros.put("usuario", usuario.getText().toString());
                parametros.put("clave", clave.getText().toString());
                parametros.put("nombre", nombre.getText().toString());
                parametros.put("apellidoP", apellidoP.getText().toString());
                parametros.put("apellidoM", apellidoM.getText().toString());
                return parametros;
            }
        };
        requestQueue.add(strq);
    }

    /*public void responseHandler(String res){
        try {
            JSONArray response = new JSONArray(res);
            //Toast.makeText(this, res, Toast.LENGTH_LONG).show();
            for(int i = 0, e = response.length(); i < e; i++){
                JSONObject categoria = (JSONObject) response.get(i);

                String nombre = categoria.get("nombre").toString();

                Categoria cat = new Categoria(
                        Integer.parseInt(categoria.get("id").toString()),
                        (String) categoria.get("nombre")
                );
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }*/
}
