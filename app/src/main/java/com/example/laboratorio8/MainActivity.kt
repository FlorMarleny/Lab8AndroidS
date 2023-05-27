package com.example.laboratorio8

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var bookAdapter: BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Dummy data for demonstration purposes
        val bookList = ArrayList<Book>()
        val maxTituloLongitud = 25
        val maxDescripcionLongitud = 125

        // Libro 1

        var titulo1 = "Odisea - Homero"

        var descripcion1 = "<<«Mientras los maderos están sujetos por las clavijas, seguiré aquí " +
                "y sufriré los males que haya de padecer, y luego que las olas deshagan la balsa me " +
                "pondré a nadar, pues no se me ocurre nada más provechoso»."

        if (titulo1.length > maxTituloLongitud) {
            titulo1 = titulo1.substring(0, maxTituloLongitud) + "..."
        }
        if (descripcion1.length > maxDescripcionLongitud) {
            descripcion1 = descripcion1.substring(0, maxDescripcionLongitud) + "..."
        }
        bookList.add(Book(titulo1, descripcion1, R.mipmap.ic_odisea))

        // Libro 2

        var titulo2 = "Don Quijote de la Mancha, Miguel de Cervantes"

        var descripcion2 = "<<El amor junta los cetros con los cayados; la grandeza con la bajeza; " +
                "hace posible lo imposible; iguala diferentes estados y viene a ser poderoso como la muerte>>"

        if (titulo2.length > maxTituloLongitud) {
            titulo2 = titulo2.substring(0, maxTituloLongitud) + "..."
        }
        if (descripcion2.length > maxDescripcionLongitud) {
            descripcion2 = descripcion2.substring(0, maxDescripcionLongitud) + "..."
        }
        bookList.add(Book(titulo2, descripcion2, R.mipmap.ic_quijote))

        // Libro 3

        var titulo3 = "El principito, de Antoine de Saint-Exupéry"

        var descripcion3 = "<<He aquí mi secreto. Es muy simple: no se ve bien sino con el corazón. " +
                "Lo esencial es invisible a los ojos>>."

        if (titulo3.length > maxTituloLongitud) {
            titulo3 = titulo3.substring(0, maxTituloLongitud) + "..."
        }
        if (descripcion3.length > maxDescripcionLongitud) {
            descripcion3 = descripcion3.substring(0, maxDescripcionLongitud) + "..."
        }
        bookList.add(Book(titulo3, descripcion3, R.mipmap.ic_principito))

        bookAdapter = BookAdapter(bookList)
        recyclerView.adapter = bookAdapter
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_buscar, menu)

        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView

        // Configurar escuchador de eventos de búsqueda si es necesario

        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_search -> {
                // Aquí puedes realizar las acciones relacionadas con la búsqueda
                return true
            }
            // Otros casos de opciones de menú si los tienes
        }
        return super.onOptionsItemSelected(item)
    }


}
