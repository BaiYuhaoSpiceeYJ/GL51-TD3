package gl51.movie.service.impl

import gl51.movie.data.Movie
import gl51.movie.service.MovieClient
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class MovieClientImplTest extends Specification {

    @Inject
    MovieRegistryImpl registry

    @Inject
    MovieClient movieClient = Mock()

    void "injection should work "() {
        expect:
        registry != null
        movieClient != null
    }

    void "get a movie by imdbID should work"() {
        when:
        //client mock
        movieClient.getMovieDetail("hello")
        then:
        // add to favorite
        Movie movie = new Movie(imdbID: "hellit")
        registry.addMovieToFavorites(movie.imdbID)
        registry.listFavorites().size()==1
    }
}