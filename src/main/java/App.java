import static java.lang.Integer.parseInt;

import models.Heroes;
import models.Squads;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        //get landing page
        get("/", (request, response) -> {
            Map<String, Object> user = new HashMap<>();
            return new ModelAndView(user, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //get heroes form
        get("/squads/new", (request, response) -> {
            Map<String, Object> user = new HashMap<>();
            return new ModelAndView(user, "Heroes-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/squads/new", App::handle, new HandlebarsTemplateEngine());

        //get heroes page
        get("/squads", (request, response) -> {
            Map<String, Object> user = new HashMap<>();
            user.put("userSquad", Squads.getAllSquads());
            return new ModelAndView(user, "Heroes.hbs");
        }, new HandlebarsTemplateEngine());

        //get squads form
        get("/Squads/new", (request, response) -> {
            Map<String, Object> user = new HashMap<>();;
            return new ModelAndView(user, "Squads-form.hbs");
        }, new HandlebarsTemplateEngine());

        //get squads page
          get("/Squads/:id/heroes", (request, response) -> {
            Map<String, Object> user  = new HashMap<>();
            int theId = parseInt(request.params("id"));
            Squads squad = Squads.squadWithId(theId);
            user.put("allHeroes", squad.getHeroesInSquad());
            return new ModelAndView(user, "Squads.hbs");
        }, new HandlebarsTemplateEngine());

          //post squads page
       post("/Squads/:id/new", (request, response) -> {
            Map<String, Object> user = new HashMap<>();
            int theId = parseInt(request.params("id"));
            Squads squad = Squads.squadWithId(theId);
            String squadName = request.queryParams("squadName");
            int maxSize = parseInt(request.queryParams("maxSize"));
            String motive = request.queryParams("motive");
            Heroes newHero = new Heroes(squadName, maxSize, motive);
            if (squad.getMaxHeroes() <= squad.getHeroesInSquad().size()){
                String sorry = "Sorry, this squad is full";
                user.put("full", sorry);
            }else{
                squad.addHero(newHero);
                user.put("heroes", squad.getHeroesInSquad());
            }
            return new ModelAndView(user, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //get squads success page
        get("/squads/:id/delete", (req, res) -> {
            Map<String, Object> user = new HashMap<>();
            int theId = parseInt(req.params("id"));
            Squads pageId = Squads.squadWithId(theId);
            pageId.deleteSquad();
            return new ModelAndView(user, "success.hbs");
        }, new HandlebarsTemplateEngine());
    }

    //post heroes
    private static ModelAndView handle(Request request, Response response) {
        Map<String, Object> user = new HashMap<>();
        String squadName = request.queryParams("squadName");
        String theme = request.queryParams("theme");
        String weak = request.queryParams("weak");
        String url = request.queryParams("url");
        int numberOf = parseInt(request.queryParams("max"));
        Squads userSquad;
        userSquad = new Squads(squadName, theme, weak, url, numberOf);
        user.put("userSquad", Squads.getAllSquads());
        return new ModelAndView(user, "Hero-success.hbs");
    }
}