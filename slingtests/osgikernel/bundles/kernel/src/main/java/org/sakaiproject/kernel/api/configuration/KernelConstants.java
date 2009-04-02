/*
 * Licensed to the Sakai Foundation (SF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The SF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package org.sakaiproject.kernel.api.configuration;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Map;

/**
 * Holds the configuration properties that are used in the kernel. This is an OSGi Managed
 * service that collects together all the configuation properties.
 * 
 * 
 * @scr.component immediate="true" label="Sakai Configuration Service"
 *                description="Provides Configuration for kernel components"
 * @scr.property name="service.description" value="Implementation of the Configuration Service that provides setup properties for all kernel bundles."
 * @scr.property name="service.vendor" value="The Sakai Foundation"
 * @scr.service interface="org.sakaiproject.kernel.api.configuration.ConfigurationService"
 * 
 */
public class KernelConstants implements ConfigurationService, ManagedService {


  /**
   * 
   * @scr.property value="/userenv" type="String" 
   *     name="JCR User Environment Base Path" 
   *     description="The location of system private data in the repo, read only, one time configuration per repository."
   */
  public static final String JCR_USERENV_BASE = "jcruserenv.base";
  /**
   * list of templates in the form type=path;type=path;
   * @scr.property value="jcruserenv.templates=student=/configuration/defaults/usertypes/userenv-student.json;researcher=/configuration/defaults/usertypes/userenv-researcher.json;" 
   *     type="String"
   */
  public static final String JCR_USERENV_TEMPLATES = "jcruserenv.templates";
  /**
   * The default template for a user
   * @scr.property value="/configuration/defaults/usertypes/userenv-default.json" type="String"
   */
  public static final String JCR_DEFAULT_TEMPLATE = "jcruserenv.templates.default";
  /**
   * list of profile templates in the form type=path;type=path;
   * @scr.property value="/configuration/defaults/usertypes/profile-student.json;researcher=/configuration/defaults/usertypes/profile-researcher.json;" type="String"
   */
  public static final String JCR_PROFILE_TEMPLATES = "jcrprofile.templates";
  /**
   * The default template for a user
   * @scr.property value="/configuration/defaults/usertypes/profile-default.json" type="String"
   */
  public static final String JCR_PROFILE_DEFAUT_TEMPLATES = "jcrprofile.templates.default";
  /**
   * The template locations for site creation.
   * @scr.property value="project=/configuration/defaults/sitetypes/project-site.json;course=/configuration/defaults/sitetypes/course-site.json;" type="String"
   */
  public static final String JCR_SITE_TEMPLATES = "jcrsite.templates";
  /**
   * Default site template.
   * @scr.property value="/configuration/defaults/sitetypes/default-site.json" type="String"
   */
  public static final String JCR_SITE_DEFAULT_TEMPLATE = "jcrsite.templates.default";

  /**
   * The property name defining the shared private data
   * 
   * @scr.property value="/_private" type="String"
   */
  public static final String PRIVATE_SHARED_PATH_BASE = "jcrprivateshared.base";
  /**
   * The property name defining the data that is completely private to the user.
   * 
   * @scr.property value="/_userprivate" type="String"
   */
  public static final String PRIVATE_PATH_BASE = "jcrprivate.base";
  /**
   * Setting: The time to live of User Env objects the local cache, this should be set in
   * the kernel properties file.
   * @scr.property value="600000" type="String"
   */
  public static final String TTL = "userenvironment.ttl";

  /**
   *  This controls whether anonymous account creation is enabled. I also enables the ability to 
   *  to check for the existence of eids in the system anonymously....without being superuser.
   * @scr.property value="true" type="String"
   */
  public static final String PROP_ANON_ACCOUNTING = "rest.user.anonymous.account.creation";
  /**
   * Control over the JPA Entity Manager scope, can be THREAD if its really stable 
   * although this means the filter must commit, or REQUEST, then the standard filter manages commits
   * @scr.property value="REQUEST" type="String"
   */
  public static final String ENTITY_MANAGER_SCOPE = "jpa.entitymanager.scope";

  /**
   * @scr.property value="org.apache.derby.jdbc.EmbeddedDriver" type="String"
   */
  public static final String JDBC_DRIVER_NAME = "jdbc.driver";
  /**
   * @scr.property value="jdbc:derby:target/testdb;create=true" type="String"
   */
  public static final String JDBC_URL = "jdbc.url";
  /**
   * @scr.property value="sa" type="String"
   */
  public static final String JDBC_USERNAME = "jdbc.username";
  /**
   * @scr.property value="" type="String"
   */
  public static final String JDBC_PASSWORD = "jdbc.password";
  /**
   * @scr.property value="values(1)" type="String"
   */
  public static final String JDBC_VALIDATION_QUERY = "jdbc.validation";
  /**
   * @scr.property value="false" type="String"
   */
  public static final String JDBC_DEFAULT_READ_ONLY = "jdbc.defaultReadOnly";
  /**
   * @scr.property value="true" type="String"
   */
  public static final String JDBC_DEFAULT_AUTO_COMMIT = "jdbc.defaultAutoCommit";
  /**
   * @scr.property value="false" type="String"
   */
  public static final String JDBC_DEFAULT_PREPARED_STATEMENTS = "jdbc.defaultPreparedStatement";
  /**
   * @scr.property value="600" type="String"
   */
  public static final String TRANSACTION_TIMEOUT_SECONDS = "transaction.timeoutSeconds";
  /**
   * @scr.property value="1" type="String"
   */
  public static final String DB_MIN_WRITE = "eclipselink.write.min";
  /**
   * @scr.property value="1" type="String"
   */
  public static final String DB_MIN_NUM_READ = "eclipselink.read.min";
  /**
   * @scr.property value="default" type="String"
   */
  public static final String DB_UNITNAME = "jpa.unitname";
  /**
   * @scr.property value="SAKAIID" type="String"
   */
  public static final String SESSION_COOKIE = "http.global.cookiename";


  /**
   * @scr.property value="" type="String"
   */
  public static final String SUBJECT_PROVIDER_REGISTRY = "subjectstatement.provider";
  /**
   * The name of the registry used for this type of service.
   * @scr.property value="" type="String"
   */
  public static final String AUTHENTICATION_PROVIDER_REGISTRY = "authentication.provider.registry";
  /**
   * @scr.property value="" type="String"
   */
  public static final String MANAGER_PROVIDER_REGISTRY = "authentication.manager.provider.registry";
  /**
   * The name of the registry used for this type of service.
   * @scr.property value="" type="String"
   */
  public static final String USER_PROVIDER_REGISTRY = "user.provider.registry";

  
  
  
  

  // constant properties
  /**
   * Name of the groupdef file.
   */
  public static final String GROUP_FILE_NAME = "groupdef.json";
  /**
   * The Name of the userenv file in the system.
   */
  public static final String USERENV = "userenv";

  /**
   * The name of the profile file.
   */
  public static final String PROFILE_JSON = "profile.json";

  /**
   * The name of the friends file
   */
  public static final String FRIENDS_FILE = "friends.json";

  /**
   * Attribute used in the session to store a list of group memberships.
   */
  public static final String GROUPMEMBERSHIP = "userenv.grouplist";
  /**
   * A null user environment file.
   */
  public static final String NULLUSERENV = "userenv.null";
  /**
   */
  public static final String JSON_CLASSMAP = "jsonconverter.classmap";
  /**
   */
  public static final String OUTBOX = "outbox";
  /**
   */
  public static final String MESSAGES = "messages";

  
  /**
   * The configuration map
   */
  private ImmutableMap<String, String> configMap;

  /**
   * {@inheritDoc}
   * 
   * @see org.osgi.service.cm.ManagedService#updated(java.util.Dictionary)
   */
  @SuppressWarnings("unchecked")
  public void updated(Dictionary config) throws ConfigurationException {
    Builder<String, String> builder = ImmutableMap.builder();
    for (Enumeration<?> e = config.keys(); e.hasMoreElements();) {
      String k = (String) e.nextElement();
      builder.put(k, (String)config.get(k));
    }
    configMap = builder.build();
  }

  public Map<String, String> getProperties() {
    return configMap;
  }

  /**
   * {@inheritDoc}
   * @see org.sakaiproject.kernel.api.configuration.ConfigurationService#getProperty()
   */
  public String getProperty(String key) {
    return configMap.get(key);
  }

  /**
   * {@inheritDoc}
   * @see org.sakaiproject.kernel.api.configuration.ConfigurationService#addListener(org.sakaiproject.kernel.api.configuration.ConfigutationListener)
   */
  public void addListener(ConfigutationListener listener) {
    // TODO Auto-generated method stub
    
  }

  /**
   * {@inheritDoc}
   * @see org.sakaiproject.kernel.api.configuration.ConfigurationService#removeListener(org.sakaiproject.kernel.api.configuration.ConfigutationListener)
   */
  public void removeListener(ConfigutationListener listener) {
    // TODO Auto-generated method stub
    
  }

}
