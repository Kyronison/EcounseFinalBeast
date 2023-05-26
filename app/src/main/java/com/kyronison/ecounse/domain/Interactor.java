package com.kyronison.ecounse.domain;

public interface Interactor {
    public void fetchLastPrices(LastPricesCallback lastPricesCallback, String type);

    class Base implements Interactor{
        private Repository repository;
        private PricesMapper pricesMapper;

        public Base(Repository repository, PricesMapper pricesMapper) {
            this.repository = repository;
            this.pricesMapper = pricesMapper;
        }

        @Override
        public void fetchLastPrices(LastPricesCallback lastPricesCallback, String type) {
            repository.fetchData(lastPricesCallback, type);
        }
    }
}

