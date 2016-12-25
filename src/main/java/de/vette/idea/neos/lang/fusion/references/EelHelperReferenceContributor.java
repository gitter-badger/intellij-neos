/*
 *  IntelliJ IDEA plugin to support the Neos CMS.
 *  Copyright (C) 2016  Christian Vette
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package de.vette.idea.neos.lang.fusion.references;

import com.intellij.patterns.PlatformPatterns;
import com.intellij.patterns.StandardPatterns;
import com.intellij.psi.*;
import de.vette.idea.neos.NeosProjectComponent;
import de.vette.idea.neos.lang.fusion.psi.FusionCompositeElement;
import de.vette.idea.neos.lang.fusion.psi.FusionExpressionIdentifier;
import de.vette.idea.neos.lang.fusion.psi.FusionPrototypeInheritance;
import de.vette.idea.neos.lang.fusion.psi.FusionTypes;
import de.vette.idea.neos.lang.fusion.psi.impl.FusionExpressionIdentifierImpl;
import org.jetbrains.annotations.NotNull;

public class EelHelperReferenceContributor extends PsiReferenceContributor {

    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        NeosProjectComponent.getLogger().info("register reference providers");
        PsiReferenceProvider eelHelperProvider = new EelHelperReferenceProvider();
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(FusionPrototypeInheritance.class), eelHelperProvider);
    }
}
