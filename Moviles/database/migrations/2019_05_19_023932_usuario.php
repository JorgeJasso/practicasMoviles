<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class Usuario extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('TablaUsuario', function (Blueprint $table) {
            $table->increments('id');
            $table->string('usuario');
            $table->string('clave');
            $table->string('nombre');
            $table->string('apellidoP');
            $table->string('apellidoM');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('TablaUsuario');
    }
}
