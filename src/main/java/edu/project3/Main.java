package edu.project3;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private final static Logger LOGGER = LogManager.getLogger();

    private Main() {
    }

    @SuppressWarnings({"MultipleStringLiterals", "RegexpSinglelineJava"})
    public static void main(String[] args) {
        Options options = new Options();
        options.addOption("p", "path", true, "Path to NGINX log file(s) (local template or URL)");
        options.addOption("f", "from", true, "Start date for log analysis in ISO8601 format");
        options.addOption("t", "to", true, "End date for log analysis in ISO8601 format");
        options.addOption("fmt", "format", true, "Output format (markdown or adoc)");

        String path = null;
        String from = null;
        String to = null;
        String format = null;

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);

            path = cmd.getOptionValue("path");
            from = cmd.getOptionValue("from");
            to = cmd.getOptionValue("to");
            format = cmd.getOptionValue("format");
        } catch (ParseException e) {
            LOGGER.error("Error parsing command line arguments: " + e.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("java -jar nginx-log-stats.jar", options);
        }

        LogAnalyzer logAnalyzer = new LogAnalyzer();
        LogStatistic logStatistic = logAnalyzer.analyzeLogs(path, from, to);
        System.out.println(ReportGenerator.generateReport(logStatistic, format));
    }
}
