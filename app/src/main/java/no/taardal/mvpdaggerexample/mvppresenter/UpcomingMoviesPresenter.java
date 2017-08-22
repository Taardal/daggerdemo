package no.taardal.mvpdaggerexample.mvppresenter;

import java.util.List;

import javax.inject.Inject;

import no.taardal.mvpdaggerexample.listener.MovieListener;
import no.taardal.mvpdaggerexample.movie.Movie;
import no.taardal.mvpdaggerexample.mvpmodel.UpcomingModel;
import no.taardal.mvpdaggerexample.mvpview.MoviesView;

public class UpcomingMoviesPresenter implements UpcomingPresenter, MovieListener {

    private MoviesView moviesView;
    private UpcomingModel upcomingModel;

    @Inject
    public UpcomingMoviesPresenter(MoviesView moviesView, UpcomingModel upcomingModel) {
        this.moviesView = moviesView;
        this.upcomingModel = upcomingModel;
    }

    @Override
    public void onViewReady() {
        upcomingModel.getUpcomingMovies(this);
    }

    @Override
    public void onSuccess(List<Movie> movies) {
        moviesView.setMovies(movies);
    }

    @Override
    public void onFailure() {
        moviesView.showErrorMessage();
    }

}