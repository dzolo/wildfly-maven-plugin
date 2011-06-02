/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2010, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.as.plugin.deployment;

import java.io.IOException;

import org.jboss.as.controller.client.helpers.standalone.DeploymentPlan;
import org.jboss.as.controller.client.helpers.standalone.DeploymentPlanBuilder;

/**
 * Redeploys the archived result of the project to the application server.
 * <p>
 * Example Usage: {@literal
 *    <build>
 *        <plugins>
 *            ...
 *            <plugin>
 *                <groupId>org.jboss.as.plugins</groupId>
 *                <artifactId>jboss-as-deploy-plugin</artifactId>
 *                <version>1.0.0-SNAPSHOT</version>
 *                <executions>
 *                    <execution>
 *                        <phase>package</phase>
 *                        <goals>
 *                            <goal>redeploy</goal>
 *                        </goals>
 *                    </execution>
 *                </executions>
 *            </plugin>
 *            ...
 *        </plugins>
 *    </build>
 * }
 * </p>
 *
 * @goal redeploy
 *
 * @author James R. Perkins Jr. (jrp)
 */
public final class Redeploy extends AbstractDeployment {

    @Override
    public DeploymentPlan createPlan(final DeploymentPlanBuilder builder) throws IOException {
        DeploymentPlan plan = null;
        if (name() == null) {
            plan = builder.replace(file()).redeploy(filename()).build();
        } else {
            plan = builder.replace(name(), file()).redeploy(name()).build();
        }
        return plan;
    }

    @Override
    public String goal() {
        return "redeploy";
    }

}