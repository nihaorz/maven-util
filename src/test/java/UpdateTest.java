import com.github.nihaorz.maven.util.MavenVersionUpdateUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nihaorz
 */
public class UpdateTest {

    /**
     * pom.xml文件
     */
    protected static final String POM_XML = "\\pom.xml";

    private static final String VERSION = "2.0.1.0.RELEASE";

    public static final List<String> pomList = new ArrayList<String>();

    /**
     * 初始化pomList
     */
    @Before
    public void initPomList() {

        /**
         * 添加parent
         */
        pomList.add(SourcePath.GEOSTACK_COMPONENT_PATH + File.separator + "geostack-parent" + POM_XML);
        pomList.add(SourcePath.GEOSTACK_COMPONENT_PATH + File.separator + "geostack-3rd-framework" + POM_XML);
        pomList.add(SourcePath.GEOSTACK_COMPONENT_PATH + File.separator + "geostack-manager-parent" + POM_XML);
        pomList.add(SourcePath.CLOUD_PLATFORM_COMPONENT_PATH + File.separator + "geostack-cloud-parent" + POM_XML);
        pomList.add(SourcePath.GEOSTACK_FUSIONMANAGER_PARENT_PATH + POM_XML);

        /**
         * 添加GeoCloudActiveMQClient
         */
        pomList.add(SourcePath.GEO_CLOUD_ACTIVE_MQ_CLIENT_PATH + POM_XML);

        /**
         * 添加geostack组件
         */
        pomList.add(SourcePath.GEOSTACK_COMPONENT_PATH + File.separator + "geostack-balance-core" + POM_XML);
        pomList.add(SourcePath.GEOSTACK_COMPONENT_PATH + File.separator + "geostack-balance-haproxy" + POM_XML);
        pomList.add(SourcePath.GEOSTACK_COMPONENT_PATH + File.separator + "geostack-core" + POM_XML);
        pomList.add(SourcePath.GEOSTACK_COMPONENT_PATH + File.separator + "geostack-databasegoods" + POM_XML);
        pomList.add(SourcePath.GEOSTACK_COMPONENT_PATH + File.separator + "geostack-dependence" + POM_XML);
        pomList.add(SourcePath.GEOSTACK_COMPONENT_PATH + File.separator + "geostack-dictionary" + POM_XML);
        pomList.add(SourcePath.GEOSTACK_COMPONENT_PATH + File.separator + "geostack-dispatch" + POM_XML);
        pomList.add(SourcePath.GEOSTACK_COMPONENT_PATH + File.separator + "geostack-framework" + POM_XML);
        pomList.add(SourcePath.GEOSTACK_COMPONENT_PATH + File.separator + "geostack-gistools" + POM_XML);
        pomList.add(SourcePath.GEOSTACK_COMPONENT_PATH + File.separator + "geostack-log" + POM_XML);
        pomList.add(SourcePath.GEOSTACK_COMPONENT_PATH + File.separator + "geostack-portal" + POM_XML);
        pomList.add(SourcePath.GEOSTACK_COMPONENT_PATH + File.separator + "geostack-processfactory" + POM_XML);
        pomList.add(SourcePath.GEOSTACK_COMPONENT_PATH + File.separator + "geostack-proxy" + POM_XML);
        pomList.add(SourcePath.GEOSTACK_COMPONENT_PATH + File.separator + "geostack-quartz" + POM_XML);
        pomList.add(SourcePath.GEOSTACK_COMPONENT_PATH + File.separator + "geostack-rest-manage" + POM_XML);
        pomList.add(SourcePath.GEOSTACK_COMPONENT_PATH + File.separator + "geostack-servicegoods" + POM_XML);
        pomList.add(SourcePath.GEOSTACK_COMPONENT_PATH + File.separator + "geostack-telescopic" + POM_XML);
        pomList.add(SourcePath.GEOSTACK_COMPONENT_PATH + File.separator + "geostack-test" + POM_XML);
        pomList.add(SourcePath.GEOSTACK_COMPONENT_PATH + File.separator + "OperationCenter" + POM_XML);

        /**
         * 添加独立运维组件
         */
        pomList.add(SourcePath.DULIYUNWEI_COMPONENT_PATH + File.separator + "geostack-soms" + POM_XML);
        pomList.add(SourcePath.DULIYUNWEI_COMPONENT_PATH + File.separator + "geostack-zabbix" + POM_XML);

        /**
         * 添加监控组件
         */
        pomList.add(SourcePath.MONITOR_COMPONENT_PATH + File.separator + "geostack-monitor-common" + POM_XML);
        pomList.add(SourcePath.MONITOR_COMPONENT_PATH + File.separator + "geostack-monitor-spark" + POM_XML);
        pomList.add(SourcePath.MONITOR_COMPONENT_PATH + File.separator + "geostack-monitor-zabbix" + POM_XML);
        pomList.add(SourcePath.MONITOR_COMPONENT_PATH + File.separator + "geostack-spark-api" + POM_XML);
        pomList.add(SourcePath.MONITOR_COMPONENT_PATH + File.separator + "geostack-spark-metrics" + POM_XML);
        pomList.add(SourcePath.MONITOR_COMPONENT_PATH + File.separator + "geostack-zabbix-api" + POM_XML);

        /**
         * 添加用户系统
         */
        pomList.add(SourcePath.USERSYSTEM_COMPONENT_PATH + File.separator + "Usersystem" + POM_XML);

        /**
         * 添加云平台隔离驱动
         */
        pomList.add(SourcePath.CLOUD_PLATFORM_COMPONENT_PATH + File.separator + "geostack-cloud-cloudstack" + POM_XML);
        pomList.add(SourcePath.CLOUD_PLATFORM_COMPONENT_PATH + File.separator + "geostack-cloud-common" + POM_XML);
        pomList.add(SourcePath.CLOUD_PLATFORM_COMPONENT_PATH + File.separator + "geostack-cloud-docker" + POM_XML);
        pomList.add(SourcePath.CLOUD_PLATFORM_COMPONENT_PATH + File.separator + "geostack-cloud-libvirt" + POM_XML);
        pomList.add(SourcePath.CLOUD_PLATFORM_COMPONENT_PATH + File.separator + "geostack-cloud-manageone" + POM_XML);
        pomList.add(SourcePath.CLOUD_PLATFORM_COMPONENT_PATH + File.separator + "geostack-cloud-openstack" + POM_XML);
        pomList.add(SourcePath.CLOUD_PLATFORM_COMPONENT_PATH + File.separator + "geostack-cloud-ucloud" + POM_XML);
        pomList.add(SourcePath.CLOUD_PLATFORM_COMPONENT_PATH + File.separator + "geostack-docker-api" + POM_XML);
        pomList.add(SourcePath.CLOUD_PLATFORM_COMPONENT_PATH + File.separator + "geostack-manageone-api" + POM_XML);
        pomList.add(SourcePath.CLOUD_PLATFORM_COMPONENT_PATH + File.separator + "geostack-openstack-limits" + POM_XML);
        pomList.add(SourcePath.CLOUD_PLATFORM_COMPONENT_PATH + File.separator + "geostack-openstack-serverinfo" + POM_XML);
        pomList.add(SourcePath.CLOUD_PLATFORM_COMPONENT_PATH + File.separator + "geostack-ucloud-api" + POM_XML);

    }

    @Test
    public void updateVersion() {
        // step1：更新各pom文件的version值
        for (String s : pomList) {
            MavenVersionUpdateUtils.updateParentVersion(s, VERSION);
            MavenVersionUpdateUtils.updateVersion(s, VERSION);
        }
        // step2：单独打开geostack-manager-parent、geostack-cloud-parent和geostack-fusionmanager-parent修改version声明
    }

}
