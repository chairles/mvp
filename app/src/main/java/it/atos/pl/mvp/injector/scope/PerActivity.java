package it.atos.pl.mvp.injector.scope;

/**
 * Created by Karol Maciejewski_ on 23.08.2016.
 */
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Scope
@Retention(RUNTIME) public @interface PerActivity {}