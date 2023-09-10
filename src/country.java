class Country {
    private String name;
    private double area; // In square kilometers
    private long population;
    private String language;
    private String currency;
    private double gdp; // In USD trillion
    private String government;
    private String timezone;
    private String religion;
    private String climate;
    private int tourismRank;

    public Country(String name, double area, long population, String language, String currency,
                   double gdp, String government, String timezone, String religion, String climate,
                   int tourismRank) {
        this.name = name;
        this.area = area;
        this.population = population;
        this.language = language;
        this.currency = currency;
        this.gdp = gdp;
        this.government = government;
        this.timezone = timezone;
        this.religion = religion;
        this.climate = climate;
        this.tourismRank = tourismRank;
    }

    public double calculateSimilarity(Country otherCountry) {
        double weightArea = 0.1;
        double weightPopulation = 0.15;
        double weightLanguage = 0.05;
        double weightCurrency = 0.05;
        double weightGDP = 0.1;
        double weightGovernment = 0.05;
        double weightTimezone = 0.05;
        double weightReligion = 0.1;
        double weightClimate = 0.1;
        double weightTourismRank = 0.15;

        double distance = Math.sqrt(
                Math.pow((area - otherCountry.area) * weightArea, 2) +
                        Math.pow((population - otherCountry.population) * weightPopulation, 2) +
                        Math.pow((language.equals(otherCountry.language) ? 0 : 1) * weightLanguage, 2) +
                        Math.pow((currency.equals(otherCountry.currency) ? 0 : 1) * weightCurrency, 2) +
                        Math.pow((gdp - otherCountry.gdp) * weightGDP, 2) +
                        Math.pow((government.equals(otherCountry.government) ? 0 : 1) * weightGovernment, 2) +
                        Math.pow((timezone.equals(otherCountry.timezone) ? 0 : 1) * weightTimezone, 2) +
                        Math.pow((religion.equals(otherCountry.religion) ? 0 : 1) * weightReligion, 2) +
                        Math.pow((climate.equals(otherCountry.climate) ? 0 : 1) * weightClimate, 2) +
                        Math.pow((tourismRank - otherCountry.tourismRank) * weightTourismRank, 2)
        );

        return 1 / (1 + distance);
    }

    public String getName() {
        return name;
    }
}
