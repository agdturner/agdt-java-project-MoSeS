This code is dependent on MPJExpress which is hopefully available via:
http://sourceforge.net/projects/mpjexpress/
A version of MPJExpress should be available in dependencies. To install mpi.jar use the following after changing to the directory containing the Jar file (in dependencies):
mvn install:install-file -Dfile=mpi.jar -DgroupId=mpi -Dversion=0.43 -DartifactId=mpj -Dpackaging=jar -DgeneratePom=true

To install MoSeS_Toy_Model-0.1.jar use the following after changing to the directory containing the Jar file (in dependencies):
mvn install:install-file -Dfile=MoSeS_Toy_Model-0.1.jar -DgroupId=uk.ac.leeds.sog.moses -Dversion=0.1 -DartifactId=MoSeS_Toy_Model -Dpackaging=jar -DgeneratePom=true
