<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class modeloUsuario extends Model
{
    protected $table='tablausuario';
    protected $fillable=[
        'usuario','clave','nombre','apellidoP','apellidoM'
    ];
}
