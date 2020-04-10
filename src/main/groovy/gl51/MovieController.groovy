package gl51

import gl51.data.MovieRequest
import gl51.movie.data.Movie
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Post


@Controller("/movie")
class MovieController {

    @Get("/")
    List<Movie> index() {
        []
    }

    @Post('/')
    HttpStatus addMovie(MovieRequest movieRequest) {
        HttpStatus.CREATED
    }
}