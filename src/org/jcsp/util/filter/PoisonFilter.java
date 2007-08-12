    //////////////////////////////////////////////////////////////////////
    //                                                                  //
    //  JCSP ("CSP for Java") Libraries                                 //
    //  Copyright (C) 1996-2006 Peter Welch and Paul Austin.            //
    //                2001-2004 Quickstone Technologies Limited.        //
    //                                                                  //
    //  This library is free software; you can redistribute it and/or   //
    //  modify it under the terms of the GNU Lesser General Public      //
    //  License as published by the Free Software Foundation; either    //
    //  version 2.1 of the License, or (at your option) any later       //
    //  version.                                                        //
    //                                                                  //
    //  This library is distributed in the hope that it will be         //
    //  useful, but WITHOUT ANY WARRANTY; without even the implied      //
    //  warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR         //
    //  PURPOSE. See the GNU Lesser General Public License for more     //
    //  details.                                                        //
    //                                                                  //
    //  You should have received a copy of the GNU Lesser General       //
    //  Public License along with this library; if not, write to the    //
    //  Free Software Foundation, Inc., 59 Temple Place, Suite 330,     //
    //  Boston, MA 02111-1307, USA.                                     //
    //                                                                  //
    //  Author contact: P.H.Welch@ukc.ac.uk                             //
    //                                                                  //
    //                                                                  //
    //////////////////////////////////////////////////////////////////////

package org.jcsp.util.filter;

import org.jcsp.lang.PoisonException;

/**
 * This filter will throw a <code>PoisonException</code>
 * when <code>filter(Object)</code> is called. This can be
 * used to prevent a channel from being written to or read from.
 *
 * @author Quickstone Technologies Limited
 */
public class PoisonFilter implements Filter
{
    /**
     * The message to be placed in the <code>PoisonException</code> raised.
     */
    private String message;

    /**
     * Default message.
     */
    private static String defaultMessage = "Channel end has been poisoned.";

    /**
     * Constructs a new filter with the default message.
     */
    public PoisonFilter()
    {
        this(defaultMessage);
    }

    /**
     * Constructs a new filter with a specific message.
     */
    public PoisonFilter(String message)
    {
        this.message = message;
    }

    public Object filter(Object obj)
    {
        throw new PoisonFilterException(this.message);
    }
}
