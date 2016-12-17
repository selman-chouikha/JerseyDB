package org.upec.lissi;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
@ApplicationPath("/api")
public class SCTICApplication extends Application {
private Set<Class<?>> classes = new HashSet<>();
public SCTICApplication() {
}
@Override
public Set<Class<?>> getClasses() {
classes.add(ServiceSCTIC.class);

return classes;
}
}