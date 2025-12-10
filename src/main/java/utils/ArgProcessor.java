package utils;

public class ArgProcessor {
    private final boolean helpMode;
    private final boolean traceMode;
    private final String fileIn;
    private final String fileOut;

    public boolean isHelpMode() {
        return helpMode;
    }

    public boolean isTraceMode() {
        return traceMode;
    }

    public String getFileIn() {
        return fileIn;
    }

    public String getFileOut() {
        return fileOut;
    }

    public ArgProcessor(String[] args) {
        this.helpMode = searchFlag(args, "-h");
        this.traceMode = searchFlag(args, "-t");
        this.fileIn = searchFile("in", args);
        this.fileOut = searchFile("out", args);
    }

    private boolean searchFlag(String[] args, String flag) {
        for (String arg : args) {
            if (arg.equals(flag)) {
                return true;
            }
        }
        return false;
    }

    private String searchFile(String fileType, String[] args) {
        boolean isFirst = true;

        for (String arg : args) {
            if (arg.equals("-h") || arg.equals("-t")) {
                continue;
            }

            // Para el archivo de salida, se omite el primer archivo encontrado
            if (fileType.equals("in")) {
                return arg;
            }else if (fileType.equals("out") && !isFirst) {
                return arg;
            }

            isFirst = false;
        }
        return null;
    }
}
