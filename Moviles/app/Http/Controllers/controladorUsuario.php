<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\modeloUsuario;

class controladorUsuario extends Controller
{
    public function insertar(Request $request){
          /* $rules = [
            'usuario' => 'required',
            'clave' => 'required',
            'nombre' => 'required',
            'apellidoP' => 'required',
            'apellidoM' => 'required'
        ];*/
        $datos = $request->all();
        /*$errores = $this->validate($datos,$rules);
        if(count($errores)>0){
            return $this->error($errores);
        }*/
        $usuario = new modeloUsuario;
        $usuario->usuario=$request->usuario;
        $usuario->clave=$request->clave;
        $usuario->nombre=$request->nombre;
        $usuario->apellidoP=$request->apellidoP;
        $usuario->apellidoM=$request->apellidoM;
        $usuario->save();
        //return $this->success($usuario);
        return response()->json($usuario);
    }

    public function actualizar(Request $request){   
        $array = $request->all();
        $data = modeloUsuario::find($request->id);
        if(!$data) {
            return $this->error(["Objeto no encontrado"]);
        }
        $data->update($array);
        return $this->success($data);
    }

    public function eliminar($id){
        $data = modeloUsuario::find($id);
        if(!$data) {
            return $this->error(["Objeto no encontrado"]);
        }
        
        $data->delete();
        return $this->succes(["objeto eliminado correctamente"]);
    }

    public function listar(){
        $data = modeloUsuario::get();
        return $this->success($data);
    }

    public function mostrar($id){
        $data = modeloUsuario::find($id);
        if(!$data) {
            return $this->error(["Objeto no encontrado"]);
        }
        return $this->success($data);
    }
}
