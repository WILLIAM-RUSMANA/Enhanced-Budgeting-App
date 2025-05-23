public class radomDataCategories {
    String name;
    Double baseAmount;
    Double monthlyTrend;
    Double standardDeviation;
    Double FrequencyperWeek;

    public radomDataCategories(String name, Double baseAmount, Double monthlyTrend, Double standardDeviation, Double FrequencyperWeek) {
        this.name = name;
        this.baseAmount = baseAmount;
        this.monthlyTrend = monthlyTrend;
        this.standardDeviation = standardDeviation;
        this.FrequencyperWeek = FrequencyperWeek;
        }

        public String getName() {
            return name;
        }

        public Double getBaseAmount() {
            return baseAmount;
        }

        public Double getMonthlyTrend() {
            return monthlyTrend;
        }

        public Double getStandardDeviation() {
            return standardDeviation;
        }

        public Double getFrequencyperWeek() {
            return FrequencyperWeek;
        }
    }