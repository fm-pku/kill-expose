for /f %%i in (CLS) do (
	java -classpath "C:\Users\chriswho\IdeaProjects\ownership-analyzer\soot\soot-trunk.jar;C:\Users\chriswho\IdeaProjects\ownership-analyzer\out\production\ownership-analysis" AnalysisMain -cp . org.gjt.sp.jedit.%%i
)
