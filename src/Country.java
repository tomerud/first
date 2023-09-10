public class Country {
    private String name;
    private String continent;
    private String culture;
    private String developmentLevel;
    private String averageHeight;
    private String skinColor;
    // You can add more attributes if needed

    public Country(String name, String continent, String culture, String developmentLevel, String averageHeight, String skinColor) {
        this.name = name;
        this.continent = continent;
        this.culture = culture;
        this.developmentLevel = developmentLevel;
        this.averageHeight = averageHeight;
        this.skinColor = skinColor;
    }

    private double calcStringDistance(String a, String b, double weight) {
        return Math.pow((a.equals(b) ? 0 : 1) * weight, 2);
    }

    public double calculateSimilarity(Country otherCountry) {
        return 1 / (1 + Math.sqrt(
                calcStringDistance(continent, otherCountry.continent, 0.2) +
                        calcStringDistance(culture, otherCountry.culture, 0.2) +
                        calcStringDistance(developmentLevel, otherCountry.developmentLevel, 0.2) +
                        calcStringDistance(averageHeight, otherCountry.averageHeight, 0.2) +
                        calcStringDistance(skinColor, otherCountry.skinColor, 0.2)
        ));
    }

    public String getName() {
        return name;
    }
}
