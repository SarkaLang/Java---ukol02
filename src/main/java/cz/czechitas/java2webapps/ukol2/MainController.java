package cz.czechitas.java2webapps.ukol2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private final Random random = new Random();
    private final List<String> quotes = new ArrayList<>();

    public MainController() {
        quotes.add("The best things is life are the people you love, the places you`ve been and the memories you`ve made along the way.");
        quotes.add("Whatever you are, be a good one.");
        quotes.add("If at first you don’t succeed, try, try again.");
        quotes.add("Knowledge is power.");
        quotes.add("The truth will set you free.");
        quotes.add("Three can keep a secret, if two of them are dead.");
    }
    @GetMapping("/")
    public ModelAndView quote() {
        //random number
        int randomNumber = random.nextInt(1, 7);

        //random quote
        int randomIndex = random.nextInt(quotes.size());
        String randomQuote = quotes.get(randomIndex);

        ModelAndView result = new ModelAndView("quote");
        result.addObject("randomNum", randomNumber);
        result.addObject("randomQuote", randomQuote);
      return result;
    }
}
