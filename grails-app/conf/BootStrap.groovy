import by.grussman.Role
import by.grussman.User
import by.grussman.UserRole
import org.codehaus.groovy.grails.commons.GrailsApplication
import grails.util.GrailsUtil

class BootStrap {

    def init = { servletContext ->
        if (GrailsUtil.environment == GrailsApplication.ENV_DEVELOPMENT) {

            //Role
            def r = new Role(authority: 'ROLE_USER').save();
            new Role(authority: 'ROLE_ADMIN').save();

            //Users
            def u = new User(username: 'user', password: '123', enabled: true).save();
            UserRole.create(u, r, true);

        }
    }
    def destroy = {
    }
}
