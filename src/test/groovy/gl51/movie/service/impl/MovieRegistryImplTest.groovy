package gl51.movie.service.impl

import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class MovieRegistryImplTest extends Specification {

    @Inject
    MovieRegistryImpl registry

    void "injectionShouldWork"() {
        expect:
            registry != null
    }

    void "favoritesShouldBeEmpty"() {
        expect:
            registry.listFavorites() == []
    }

    void "addingAFacoviteShouldFillInTheDatabase"() {
        when:
            registry.addMovieToFavorites("aaaaa")
        then:
            registry.listFavorites().size() == 1
    }
}
