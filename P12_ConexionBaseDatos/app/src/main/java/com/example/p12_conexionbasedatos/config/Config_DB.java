package com.example.p12_conexionbasedatos.config;

public class Config_DB {
    public static final String NAME_DB="Libros";
    public static final int VERSION_DB=1;

    public static final String[] SCRIPT_DB={
            "create table Producto(" +
                    "ID integer primary key autoincrement," +
                    "nombre varchar(35)," +
                    "cantidad int," +
                    "precio float," +
                    "fk_proveedor int," +
                    "fk_categoria int," +
                    "foreign key (fk_proveedor) references Proveedor(ID)," +
                    "foreign key (fk_categoria) references Categoria(ID)" +
            ");",
            "create table Proveedor(" +
                    "ID integer primary key autoincrement," +
                    "empresa varchar(50)" +
            ");",
            "create table Categoria(" +
                    "ID integer primary key autoincrement," +
                    "categoria varchar(35)" +
            ");"
    };
}
