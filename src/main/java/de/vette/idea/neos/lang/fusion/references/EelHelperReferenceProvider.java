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

import com.intellij.psi.*;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.ProcessingContext;
import com.intellij.util.indexing.FileBasedIndex;
import de.vette.idea.neos.NeosProjectComponent;
import de.vette.idea.neos.indexes.EelHelperFileIndex;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EelHelperReferenceProvider extends PsiReferenceProvider {

    @NotNull
    @Override
    public PsiReference[] getReferencesByElement(@NotNull PsiElement psiElement, @NotNull ProcessingContext processingContext) {
        NeosProjectComponent.getLogger().info("Test");
        String value = psiElement.getText();
        NeosProjectComponent.getLogger().info("Looking for references to: " + value);
        List<String> helpers = FileBasedIndex.getInstance().getValues(EelHelperFileIndex.KEY, value, GlobalSearchScope.projectScope(psiElement.getProject()));
        PsiReference[] references = new PsiReference[helpers.size()];
        for (String helper : helpers) {
            NeosProjectComponent.getLogger().info("Helper: " + helper);
        }

        return references;
    }
}
