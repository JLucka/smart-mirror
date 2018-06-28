package com.jlucka.mirror.module;

import com.jlucka.mirror.model.QuoteResponse;
import com.jlucka.mirror.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuotesModule implements MirrorModule {

    private boolean isVisible;
    private final String name;
    private final QuoteService quoteService;

    @Autowired
    public QuotesModule(QuoteService quoteService) {
        this.name = "quotes_module";
        this.isVisible = true;
        this.quoteService = quoteService;
    }

    public QuoteResponse getQuote() {
        return quoteService.getQuote();
    }


    @Override
    public boolean isVisible() {
        return isVisible;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void hide() {
        this.isVisible = false;
    }

    @Override
    public void show() {
        this.isVisible = true;
    }

    @Override
    public int order() {
        return 6;
    }
}