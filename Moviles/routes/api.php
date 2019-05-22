<?php

use Illuminate\Http\Request;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::group(['prefix'=>'Usuario'],function (){
    Route::post('insertar','controladorUsuario@insertar');
    Route::post('actualizar/{id}','controladorUsuario@actualizar');
    Route::delete('eliminar/{id}','controladorUsuario@eliminar');
    Route::get('/','controladorUsuario@listar');
    Route::get('/{id}','controladorUsuario@mostrar');
});

Route::middleware('auth:api')->get('/user', function (Request $request) {
    return $request->user();
});
